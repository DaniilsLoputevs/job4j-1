package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 07.04.2019
 */
public class MyQueue<E> implements Iterable<E> {

    private SimpleStack<E> input;
    private SimpleStack<E> output;
    private int size = 0;

    public MyQueue() {
        this.input = new SimpleStack<>();
        this.output = new SimpleStack<>();

    }

    /**
     * Метод использует входящий и исходящий стек для выдачи эдементов по FIFO.
     *
     * @return значение.
     * @see SimpleStack
     */
    public E poll() {
        E value;
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else if (output.isEmpty()) {
            while (!this.input.isEmpty()) {
                output.push(this.input.pol());
            }
        }
        value = output.pol();
        size--;
        return value;
    }

    /**
     * Метод добавляет в очередь элемент
     *
     * @param value элемент
     */

    public boolean push(E value) {
        boolean rs = false;
        if (!Objects.isNull(value)) {
            this.input.push(value);
            rs = true;
            size++;
        }
        return rs;
    }

    /**
     * Метод проверяет что данная структура пустая.
     *
     * @return boolean
     */

    public boolean isEmpty() {
        return this.size == 0;

    }

    /**
     * Метод возвращает размер структуры.
     *
     * @return
     */

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return input.iterator();
    }

}
