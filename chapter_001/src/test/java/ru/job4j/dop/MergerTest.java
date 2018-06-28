package ru.job4j.dop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MergerTest {
    @Test
   public void whenTwoArraysCopyForThree() {
        Merger merger = new Merger();
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {7, 8, 9, 10, 11};
        int[] result = merger.merger(a, b);
        int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertThat(result, is(expect));

    }
}