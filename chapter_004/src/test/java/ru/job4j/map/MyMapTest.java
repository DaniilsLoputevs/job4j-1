package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyMapTest {
    MyMap<Integer, String> myMap;
    MyMap<String, Integer> myMap2;

    @Before
    public void init() {
        myMap = new MyMap<>();
        myMap2 = new MyMap<>();
        myMap.insert(25, "Testing");
        myMap.insert(25, "Test");
        myMap.insert(26, "Test3");
        myMap.insert(27, "Test4");
        myMap.insert(29, "Test5");
        myMap.insert(2266659, "SomeValue");
        myMap2.insert("First", 1);
        myMap2.insert("Second", 2);
    }

    @Test
    public void insertPairAndCheckReturnValue() {
        assertThat(myMap.insert(25, "Test"), is(true));
        assertThat(myMap.insert(24, "Test"), is(true));
        assertThat(myMap.insert(24, "Test"), is(true));
        assertThat(myMap.insert(26, "Test"), is(true));
        assertThat(myMap2.insert("First", 4), is(true));
        assertThat(myMap2.insert("Second", 6), is(true));
        assertThat(myMap2.insert("Third", 3), is(true));
    }


    @Test
    public void checkSizeForMyMapStructure() {
        assertThat(myMap.getSize(), is(5));
        assertThat(myMap2.getSize(), is(2));
    }

    @Test
    public void getValue() {
        assertThat(myMap.get(25), is("Test"));
        assertThat(myMap.get(2266659), is("SomeValue"));
        assertThat(myMap2.get("First"), is(1));
    }

    @Test
    public void deleteValue() {
        assertThat(myMap2.delete("Second"), is(true));
        assertThat(myMap.delete(25), is(true));
    }

    @Test
    public void resize() {
        assertThat(myMap.getLenght(), is(32));
    }

    @Test
    public void iteratorTest() {
        Iterator<String> it = myMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("SomeValue"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Test"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Test4"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Test3"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Test5"));
        assertThat(it.hasNext(), is(false));
    }
}