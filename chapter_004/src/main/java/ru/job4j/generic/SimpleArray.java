package ru.job4j.generic;


/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 28.03.2019
 */
public class SimpleArray<T> {

    private T[] array;
    private int size;
    private int position = 0;

    /**
     * Конструктор инициализ
     *
     * @param size
     */
    public SimpleArray(int size) {
        this.size = size;
    }

    public SimpleArray(T[] array, int size) {
        this.array = array;
        this.size = size;
    }

    public void add(T value) {
        if (value.getClass().equals(array.getClass())) {
            array[position] = value;
            position++;
        } else {
            throw new ClassCastException();
        }
    }


    public static void main(String[] args) {
        SimpleArray simpleArray = new SimpleArray(10);
        simpleArray.add("Привет");

    }

}
