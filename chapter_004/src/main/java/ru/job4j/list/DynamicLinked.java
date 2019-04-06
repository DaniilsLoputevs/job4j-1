package ru.job4j.list;

import java.util.*;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 04.04.2019
 */
public class DynamicLinked<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    private int modCount;
    private int position;

    public DynamicLinked() {
        this.size = 0;
        this.modCount = 0;
        this.position = 0;
    }

    /**
     * Метод добавления в список элемента
     *
     * @param data E элемент
     * @return boolean
     */
    public boolean add(E data) {
        Node<E> newlink = new Node<>(data);
        newlink.next = this.first;
        this.first = newlink;
        increaseField();
        return true;
    }

    /**
     * Метод увеличивает значение полей при модификации списка.
     */
    public void increaseField() {
        this.position++;
        this.modCount++;
        this.size++;
    }

    /**
     * Метод проверяет что список пустой
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Метод получения E элемента по индексу
     *
     * @param index индекс искомого элемента.
     * @return E элемент.
     */
    public E get(int index) {
        if (isEmpty()) {
            return null;
        } else {
            Node<E> result = null;
            if (!Objects.isNull(first)) {
                result = this.first;
                for (int i = 0; i < index; i++) {
                    result = result.next;
                }
            }
            return result.data;
        }

    }

    public E removeFirst() {
        if (!isEmpty()) {
            Node<E> rs = first;
            first = first.next;
            this.size--;
            this.position--;
            modCount++;
            return rs.data;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Метод получения размера списка.
     *
     * @return размер .
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс для хранения значения.
     *
     * @param <E> элемент хранящий значение.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }


    @Override
    public Iterator<E> iterator() {

        Iterator<E> iterator = new Iterator<E>() {
            int itposition = 0;
            int itcount = modCount;
            Node<E> node = first;

            @Override
            public boolean hasNext() {

                return this.itposition < position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.itcount < modCount) {
                    throw new ConcurrentModificationException();
                }
                E rs = node.data;
                node = node.next;
                itposition++;
                return rs;
            }
        };
        return iterator;
    }

}

