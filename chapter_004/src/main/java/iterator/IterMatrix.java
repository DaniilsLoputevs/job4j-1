package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 25.03.2019
 */
public class IterMatrix implements Iterator {

    private final int[][] value;
    private int row = 0;
    private int column = 0;

    public IterMatrix(int[][] array) {
        this.value = array;
    }

    /**
     * Метод проверяет, что в перебираемой матрице есть элементы для перебора
     *
     * @return true/false значение
     */
    @Override
    public boolean hasNext() {
        return row < value.length && column < value[row].length;
    }

    /**
     * Метод возвращает элемент перебираемой матрицы последовательным перебором
     *
     * @return Integer элемент
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            Integer rs = value[row][column++];
            if (column > value[row].length - 1) {
                row++;
                column = 0;
            }
            return rs;
        }
    }
}
