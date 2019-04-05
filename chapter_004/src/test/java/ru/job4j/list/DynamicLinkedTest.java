package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicLinkedTest {
    DynamicLinked<String> strings;
    Iterator<String> it;

    @Before
    public void init() {
        strings = new DynamicLinked<>();
        strings.add("1 Элемент");
        strings.add("2 Элемент");
        strings.add("3 Элемент");
        it = strings.iterator();
    }

    @Test
    public void addNewValueInList() {
        assertThat(strings.add("4 элемент"), is(true));
    }

    @Test
    public void getValueByIndex() {
        assertThat(strings.get(1), is("2 Элемент"));
        assertThat(strings.get(0), is("3 Элемент"));
        assertThat(strings.get(2), is("1 Элемент"));
    }

    @Test
    public void getSizeInCurrentList() {
        strings.add("test");
        assertThat(strings.getSize(), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void itTestShoultReturnRightValue() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("3 Элемент"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2 Элемент"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1 Элемент"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenListIsEmpty() {
        DynamicLinked<Integer> integers = new DynamicLinked<>();
        assertThat(integers.isEmpty(), is(true));
        integers.add(0);
        assertThat(integers.isEmpty(), is(false));
    }

    @Test
    public void itTestShoultReturnRightValue2() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("3 Элемент"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2 Элемент"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1 Элемент"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void itTestShoultReturn() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("3 Элемент"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2 Элемент"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1 Элемент"));
        assertThat(it.hasNext(), is(false));

        final Iterator<String> iterator = strings.iterator();
        final String next = iterator.next();
        assertThat(next, is("3 Элемент"));

    }
}