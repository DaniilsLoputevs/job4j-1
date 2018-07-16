package ru.job4j.array;
/**
 * Package for array task
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * The method checks the array-true or false.
     * @param data
     * @return boolean type.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index < data.length; index++) {
            if (data[0] != data[index]) {
                result = false;
            }
        }
        return result;
    }
}

