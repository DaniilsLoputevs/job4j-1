package ru.job4j;

import org.junit.Test;
import ru.job4j.search.ConvertList2Array;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConvertList2ArrayTest {

    @Test
    public void whenConvert2Array() {
        ConvertList2Array convertList2Array = new ConvertList2Array();
        int[][] result = convertList2Array.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void whenListConvertInteger() {
        ConvertList2Array list = new ConvertList2Array();
        ArrayList<int[]> result = new ArrayList<>();
        result.add(new int[]{1, 2});
        result.add(new int[]{3, 4, 5, 6});
        ArrayList<Integer> expect = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            expect.add(i);
        }
        assertThat(list.convert(result), is(expect));
    }

}