package ru.job4j.department;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepartmentTest {
    Department data = new Department();

    @Before
    public void setUp() {
        data = new Department();
        data.addDepartament(
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2");
    }

    @Test
    public void whenGetDataThenAlphabetOrder() {
        String[] result = data.getData();
        String[] expect = new String[]{
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenGetDescendingDataThenInverseAlphabetOrder() {
        String[] result = data.getDescending();
        String[] expect = new String[]{
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"};
        assertThat(result, is(expect));
    }
}
