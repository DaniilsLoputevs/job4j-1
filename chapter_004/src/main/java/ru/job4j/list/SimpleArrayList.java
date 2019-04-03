package ru.job4j.list;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 02.04.2019
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     *
     * @param data
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Реализация метода удаления первого элемента в списке.
     */
    public E delete() {
        E tmp = null;
        if (first != null) {
            tmp = this.first.date;
            first = first.next;
            size--;
        }
        return tmp;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    public int getSize() {
        return this.size;
    }


    private static class Node<E> {
        E date;
        Node<E> next;

        public Node(E date) {
            this.date = date;
        }

    }
}
