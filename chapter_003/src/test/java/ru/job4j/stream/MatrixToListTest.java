package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void toList() {
        Integer[][] matrix = new Integer[][]{{99, 45, 21}, {566, 2008, 2019}};
        MatrixToList matrixToList = new MatrixToList();
        List<Integer> expected = List.of(99, 45, 21, 566, 2008, 2019);
        assertThat(matrixToList.toList(matrix), is(expected));
    }
}