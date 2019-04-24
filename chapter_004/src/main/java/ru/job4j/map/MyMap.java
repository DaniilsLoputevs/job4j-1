package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 20, 04, 2019
 */
public class MyMap<K, V> implements Iterable<V> {

    private Node[] entries;
    private int lenght;
    private int size;
    private int modcount;
    private double load;


    /**
     * Конструктор инициализирующий структуру по умолчанию размером 16.
     */
    public MyMap() {
        lenght = 16;
        load = 0.25;
        size = 0;
        modcount = 0;
        this.entries = new Node[lenght];

    }

    public int getLenght() {
        return lenght;
    }

    /**
     * Метод добавляет пару в структуру .
     * Проверяет , что ключ не является null и нет идиентичного ключа в структуре.
     *
     * @param key   ключ
     * @param value значение
     * @return результат добавления.
     */
    public boolean insert(K key, V value) {
        Node<K, V> n = new Node<>(key, value);
        int i = index(hash(key.hashCode()), this.getLenght());
        boolean rs = false;
        if (Objects.isNull(this.entries[i])) {
            this.entries[i] = n;
            rs = true;
            size++;
            modcount++;
        } else {
            if ((Objects.nonNull(this.entries[i]))) {
                if (this.entries[i].getKey().equals(n.getKey())) {
                    this.entries[i] = n;
                    rs = true;
                    modcount++;
                }
            }
        }
        if (checkFill()) {
            increseMap();
        }

        return rs;
    }

    /**
     * Метод возвращает значение по ключу
     *
     * @param key ключ
     * @return
     */
    public V get(K key) {
        int index = index(hash(key.hashCode()), this.getLenght());
        V value = null;
        if (this.entries[index].getKey().equals(key)) {
            value = (V) this.entries[index].getValue();
        }
        return value;

    }

    /**
     * Метод удаления из структуры
     *
     * @param key ключ
     * @return true/false
     */
    public boolean delete(K key) {
        boolean rs = false;
        int index = index(hash(key.hashCode()), this.getLenght());
        if (this.entries[index].getKey().equals(key)) {
            this.entries[index] = null;
            size--;
            modcount++;
            rs = true;
        }
        return rs;
    }

    public void increseMap() {
        Node[] tmp = new Node[lenght * 2];
        for (int i = 0; i < this.entries.length; i++) {
            if (Objects.nonNull(this.entries[i])) {
                int indextmp = index(hash(this.entries[i].getKey().hashCode()), tmp.length);
                tmp[indextmp] = this.entries[i];
            }
        }
        this.entries = tmp;
        this.lenght = tmp.length;
    }

    public boolean checkFill() {
        int rs = (int) (this.lenght * load);
        return size == rs;
    }

    /**
     * Метод вычисляет хэш-функцию для ключа.
     *
     * @param keyhash хэш ключа
     * @return результат вычесления
     */
    public int hash(int keyhash) {
        keyhash ^= (keyhash >>> 20) ^ (keyhash >>> 12);
        return keyhash ^ (keyhash >>> 7) ^ (keyhash >>> 4);
    }

    /**
     * Метод определяет бакет в который будет добавлена пара
     *
     * @param keyhash хэш ключа
     * @return индекс бакета в который попадет пара.
     */
    public int index(int keyhash, int lenght) {
        return keyhash & (lenght - 1);
    }


    /**
     * Метод возврата размера структуры не учитывая null элементы.
     *
     * @return размер.
     */
    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<V> iterator() {
        Iterator<V> iteratorMap = new Iterator<V>() {
            int iterpos = 0;
            int checkmod = modcount;

            @Override
            public boolean hasNext() {
                boolean rs = false;
                if (checkmodif()) {
                    for (int i = iterpos; i < entries.length; i++) {
                        if (Objects.nonNull(entries[i])) {
                            this.iterpos = i;
                            rs = true;
                            break;
                        }
                    }
                }
                return rs;
            }

            @Override
            public V next() {
                V value = null;
                if (hasNext()) {
                    value = (V) entries[iterpos].getValue();
                    this.iterpos++;
                } else {
                    throw new NoSuchElementException();
                }
                return value;
            }

            public boolean checkmodif() {
                boolean rs = false;
                if (checkmod == modcount) {
                    rs = true;
                } else {
                    throw new ConcurrentModificationException();
                }
                return rs;
            }
        };
        return iteratorMap;
    }

    /**
     * Node хранящий пару
     *
     * @param <K> Ключ
     * @param <V> Значение
     */
    private class Node<K, V> {
        private K key;
        private V value;


        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Геттер для получения ключа.
         *
         * @return ключ
         */
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
