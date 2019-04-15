package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 03.04.2019
 */
public class DynamicList<E> implements Iterable<E> {

    private Object[] container;
    private int modCount;
    private int position;

    /**
     * Конструктор обьекта динамического списка.
     */
    public DynamicList() {
        this.container = new Object[3];
        this.modCount = 0;
        this.position = 0;
    }

    /**
     * Метод получения размера динамического списка.
     *
     * @return размер списка.
     */
    public int getSize() {
        return this.container.length;
    }

    public int getPosition() {
        return position;
    }
    /**
     * Метод добавления в структуру динамического списка.
     *
     * @param value значение.
     */

    public void add(E value) {
        if (checkFill()) {
            resize(this.container.length * 2);
        }
        this.modCount++;
        this.container[position++] = value;
    }

    public E get(int index) {
        E value = null;
        if (index < this.container.length - 1) {
            value = (E) this.container[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
        return value;
    }

    /**
     * Метод проверки что поле position достигло размера массива -1.
     *
     * @return boolean результат.
     */

    public boolean checkFill() {
        return position == container.length - 1;
    }

    /**
     * Метод для масштабирования размера внутреннего массива .
     *
     * @param lenght
     */
    private void resize(int lenght) {
        Object[] n = new Object[lenght];
        System.arraycopy(this.container, 0, n, 0, position);
        this.container = n;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int itposition = 0;
            private int checkMod = modCount;

            @Override
            public boolean hasNext() {

                return itposition < container.length && itposition < position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (checkMod < modCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[itposition++];
            }

        };
        return iterator;
    }

}

