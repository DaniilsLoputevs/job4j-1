package ru.job4j.dop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IsSortedTest {
    @Test
    public void  WhenArraySorted () {
        IsSorted sort = new IsSorted();
        int [] input = new int[]{1,3,5,6,7,8};
        boolean result = sort.checksort(input);
        assertThat(result, is(true));


    }
    @Test
    public void  WhenArrayNotSorted () {
        IsSorted sort = new IsSorted();
        int [] input = new int[]{1,3,5,6,7,8,2};
        boolean result = sort.checksort(input);
        assertThat(result, is(false));


    }

}
