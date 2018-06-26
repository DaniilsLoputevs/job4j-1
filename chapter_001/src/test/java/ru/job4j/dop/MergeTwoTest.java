package ru.job4j.dop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MergeTwoTest {
    @Test
    public void whenTwoArraysCopyForThree() {
        MergerTwo mergerTwo = new MergerTwo();
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {7, 8, 9, 10, 11};
        int[] result = MergerTwo.mergertwo(a, b);
        int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertThat(result, is(expect));

    }
}