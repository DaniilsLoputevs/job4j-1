package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 05.04.2019
 */
public class SimpleStack<T> implements Iterable<T> {
   private DynamicLinked<T> dynamicLinked;

    /**
     * Конструктор класса создающий Стек на базе связаного списка.
     */
    public SimpleStack() {
        this.dynamicLinked = new DynamicLinked<>();
    }

    /**
     * Метод получения элемента и в последствии удаление его.
     * Используется метод удаление из класса DynamicLinked
     *
     * @return значение которое удалится впоследствии.
     */
    public T pol() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return dynamicLinked.removeFirst();
    }

    /**
     * Добавление  элемента в структуру.
     *
     * @param value != null элемент
     * @return boolean
     */
    public boolean push(T value) {
        boolean result = false;
        if (Objects.isNull(value)) {
            return result;
        } else {
            this.dynamicLinked.add(value);
            result = true;
        }
        return result;
    }

    /**
     * Метод проверки что данная структура пустая.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.dynamicLinked.isEmpty();
    }

    /**
     * Метод получения размера структуры.
     *
     * @return int значение размера структуры.
     */
    public int getSize() {
        return this.dynamicLinked.getSize();
    }


    @Override
    public Iterator<T> iterator() {
        return dynamicLinked.iterator();
    }
}
