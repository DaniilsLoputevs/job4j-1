package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 22.11.2018
 */

public class ConvertMatrix2List {
    /**
     * Метод добавляет в List<Integer> двумерный массив.
     *
     * @param array - двумерный массив
     * @return List<Integer>
     */
    public List<Integer> list(int[][] array) {
        List<Integer> integerList = new ArrayList<Integer>();
        for (int[] one : array) {
            for (int integer : one) {
                integerList.add(integer);

            }
        }
        return integerList;
    }
}
