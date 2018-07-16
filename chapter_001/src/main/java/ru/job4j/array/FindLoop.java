package ru.job4j.array;
/**
 * Package for array task
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     *
     * @param data array.
     * @param value - searching element.
     * @return index found
     */
    public int indexOf(int[] data, int value) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == value) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}