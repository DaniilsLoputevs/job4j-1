package ru.job4j.search;
import java.util.List;
/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 06.11.2018
 */

public class ConvertList2Array {
    /**
     * Метод конвертирует List<Integer> в двумерный массив.
     * @param list- Список.
     * @param rows - Строки.
     * @return - Возвращает равномерный двумерный массив , если элементов не хватает , оставшееся заполняется нулями.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer integer : list) {
            array[i][j] = integer;
            j++;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }
}
