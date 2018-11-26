package ru.job4j.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.list(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when2on2ArrayThenList4Second() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        List<Integer> expected = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8
        );
        List<Integer> result = list.list(input);
        assertThat(result, is(expected));
    }


}