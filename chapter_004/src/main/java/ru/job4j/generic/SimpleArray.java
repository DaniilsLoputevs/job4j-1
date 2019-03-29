package ru.job4j.generic;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 28.03.2019
 */
public class SimpleArray<T> implements Iterable<T> {


    private Object[] array;

    private int position = 0;

    /**
     * Конструктор инициализирует структуру и задает ей размер
     *
     * @param size Размер указанный пользователем.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }


    /**
     * Метод добавление элемента в структуру.
     *
     * @param value Элемент
     */
    public void add(T value) {
        if (!Objects.isNull(value) && position < array.length) {
            this.array[position++] = value;
        } else {
            throw new ArrayStoreException();
        }
    }

    /**
     * Метод получения обьекта по индексу
     *
     * @param index входящий индекс для поиска обьекта по индексу
     * @return найденный обьект.
     */
    public T get(int index) {
        T value = null;
        if (index < array.length) {
            value = (T) array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return value;
    }

    /**
     * Метод по замене значения в структуре по индексу
     *
     * @param index Индекс
     * @param value Значение
     */
    public void set(int index, T value) {
        if (!Objects.isNull(value) && index < array.length) {
            this.array[index] = value;
        }
    }

    /**
     * Метод удаление обьекта по индексу
     *
     * @param index
     * @return
     */
    public boolean remove(int index) {
        boolean rs = false;
        if (index < array.length) {
            array[index] = null;
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
            position--;
            rs = true;

        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return rs;
    }


    public static void main(String[] args) {
        SimpleArray<String> simpleArray = new SimpleArray(10);
        String s = "Тест";
        String s2 = "Тест2";
        String s3 = "Тест3";
        simpleArray.add(s);
        simpleArray.add(s2);
        simpleArray.add(s3);
        System.out.println(simpleArray + " ДО УДАЛЕНИЯ");
        simpleArray.remove(1);
        System.out.println(simpleArray + " ПОСЛЕ УДАЛЕНИЯ");


    }

    @Override
    public String toString() {
        return "SimpleArray{"
                +
                "array="
                + Arrays.toString(array)
                +
                ", position=" + position
                +
                '}';
    }

    /**
     * Реализация интерфейса Iterable
     *
     * @return итератор
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int itposition = 0;

            @Override
            public boolean hasNext() {
                return itposition < array.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return (T) array[itposition++];
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

}
