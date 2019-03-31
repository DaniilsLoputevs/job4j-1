package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void addIntegerInSimpleArrayTest() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(1);
        simpleArray.add(29);
        assertThat(simpleArray.get(0), is(29));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getValueInAnyPosition() {
        SimpleArray<String> stringSimpleArray = new SimpleArray<>(10);
        stringSimpleArray.add("Test");
        stringSimpleArray.add("Test2");
        stringSimpleArray.add("Test3");
        String res = stringSimpleArray.get(2);
        String expected = "Test3";
        assertThat(res, is(expected));
        assertThat(stringSimpleArray.get(9), is(nullValue()));
        stringSimpleArray.get(11);

    }

    @Test
    public void setNewValueByPosition() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        int a = 25;
        int b = 44;
        simpleArray.add(a);
        simpleArray.add(b);
        int changed = 99;
        simpleArray.set(1, changed);
        assertThat(simpleArray.get(1), is(99));

    }

    @Test
    public void whenRemoveValueIsTrueAndCheckArrayNotPerforated() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(4);
        simpleArray.add(6);
        assertThat(simpleArray.remove(1), is(true));
        assertThat(simpleArray.get(1), is(6));
    }

    @Test(expected = NoSuchElementException.class)
    public void testIterableImplementationOnCustomSimpleArray() {
        SimpleArray<String> stringSimpleArray = new SimpleArray<>(3);
        Iterator<String> is = stringSimpleArray.iterator();
        stringSimpleArray.add("СтрокаДляТеста");
        stringSimpleArray.add("СтрокаДляТеста2");
        stringSimpleArray.add("СтрокаДляТеста3");
        assertThat(is.next(), is("СтрокаДляТеста"));
        assertThat(is.next(), is("СтрокаДляТеста2"));
        assertThat(is.next(), is("СтрокаДляТеста3"));
        assertThat(is.hasNext(), is(false));
        is.next();
    }

}