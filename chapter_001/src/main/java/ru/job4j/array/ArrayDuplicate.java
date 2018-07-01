package ru.job4j.array;
/**
 * Package for array task
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int uniqdata = array.length;
        for (int out = 0; out < uniqdata; out++) {
            for (int input = out + 1; input < uniqdata; input++) {
                if (array[out].equals(array[input])) {
                    array[input] = array[uniqdata - 1];
                    uniqdata--;
                    input--;
                }
            }
        }
        return Arrays.copyOf(array, uniqdata);
    }

}