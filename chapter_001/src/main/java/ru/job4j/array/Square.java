package ru.job4j.array;
/**
 * Package for array task
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     *
     * @param bound lenght of array
     * @return squared data.
     */
    public int[] calculate(int bound) {
        int[]rst = new int[bound];
        for (int index = 0; index < bound; index++) {
            rst[index] = (int) Math.pow((index + 1), 2);


        }
        return rst;
    }
}
