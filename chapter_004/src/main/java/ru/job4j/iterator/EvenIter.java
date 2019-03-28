package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 27.03.2019
 */
public class EvenIter implements Iterator {
    private final int[] value;
    private int position = 0;

    public EvenIter(int[] value) {
        this.value = value;
    }

    /**
     * Метод проверяет есть ли чётный элемент , начиная с позиции установленной в поле обьекта EvenIter
     *
     * @return true если чётный элемент присутствует в массиве и false если нет.
     */
    @Override
    public boolean hasNext() {
        boolean rs = false;
        for (int i = this.position; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                rs = true;
                this.position = i;
                break;
            }

        }
        return rs;
    }

    /**
     * Возвращает чётный элемент , если нет то пробрасывает исключение NoSuchElementException()
     *
     * @return след элемент.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return value[this.position++];
    }
}
