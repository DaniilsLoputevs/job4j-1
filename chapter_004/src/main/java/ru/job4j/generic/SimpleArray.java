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
        if (checkinput(position, array.length - 1)) {
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
        Objects.checkIndex(index, position);
        return (T) array[index];
    }

    /**
     * Метод по замене значения в структуре по индексу
     *
     * @param index Индекс
     * @param value Значение
     */
    public void set(int index, T value) {
        Objects.checkIndex(index, array.length);
        if (checkinput(index, position)) {
            this.array[index] = value;
        } else {
            throw new IllegalArgumentException();
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
        if (checkinput(index, array.length - 1) && checkinput(index, position)) {
            array[index] = null;
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
            position--;
            rs = true;

        } else {
            throw new IllegalArgumentException();
        }
        return rs;
    }

    public boolean checkinput(int index, int value2) {
        return index <= value2;
    }


//    public static void main(String[] args) {
//        SimpleArray<String> simpleArray = new SimpleArray(10);
//        String s = "Тест";
//        String s2 = "Тест2";
//        String s3 = "Тест3";
//        simpleArray.add(s);
//        simpleArray.add(s2);
//        simpleArray.add(s3);
//        System.out.println(simpleArray + " ДО УДАЛЕНИЯ");
//        simpleArray.remove(1);
//        System.out.println(simpleArray + " ПОСЛЕ УДАЛЕНИЯ");
//        System.out.println(simpleArray.get(3));
//        simpleArray.set(3, s2);
//        System.out.println(simpleArray);
//        System.out.println(simpleArray.remove(3));
//
//    }

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
                return itposition < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[itposition++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

}
