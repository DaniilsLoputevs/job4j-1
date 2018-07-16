
package ru.job4j.array;
/**
 * Package for array task
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     *
     * @param data The square array is filled with true or false diagonals.
     * @return boolean type.
     */
    public boolean mono(boolean[][] data) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] == data[i][i] && data[0][data.length - 1] == data[data.length - 1 - i][i]) {
                result = true;
            } else {
                result = false;
                break;
            }

        }
        return result;
    }
}



