package ru.job4j.io.dop;


import java.util.*;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 05.08.2019
 */
public class ArrayWithDuplicateValue {


    public Integer[] onlyDuplicateReturn(Integer[] first, Integer[] second) {
        List<Integer> tmp = new ArrayList<>();
        Map<Integer, Integer> val = new HashMap<>();
        for (Integer f : first) {
            val.put(f, f);
        }
        for (Integer check : second) {
            if (val.containsValue(check)) {
                tmp.add(check);
            }
        }
        Integer[] result = new Integer[tmp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tmp.get(i);
        }
        return result;
    }

}
