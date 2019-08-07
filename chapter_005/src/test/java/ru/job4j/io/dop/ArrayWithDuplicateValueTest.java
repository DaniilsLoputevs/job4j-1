package ru.job4j.io.dop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ArrayWithDuplicateValueTest {

    @Test
    public void onlyDuplicateReturnArrayWithOnlyDuplacateValue() {
        ArrayWithDuplicateValue arrayWithDuplicateValue = new ArrayWithDuplicateValue();
        Integer[] first = new Integer[]{99, 2, 3, 4, 1};
        Integer[] second = new Integer[]{1, 4, 99};
        Integer[] expected = new Integer[]{1, 4, 99};
        Integer[] rs = arrayWithDuplicateValue.onlyDuplicateReturn(first, second);
        assertArrayEquals(rs, expected);
    }
}