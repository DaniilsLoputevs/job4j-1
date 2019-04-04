package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicListTest {
    DynamicList<Integer> integers;
    Iterator<Integer> it;

    @Before
    public void init() {
        integers = new DynamicList<>();
        integers.add(64);
        integers.add(100);
        it = integers.iterator();

    }

    @Test
    public void getSizeDefaultValueSize3andCheckResize() {
        assertThat(integers.getSize(), is(3));
        integers.add(964);
        assertThat(integers.getSize(), is(6));
    }

    @Test
    public void add() {
        integers.add(9999);
        assertThat(integers.get(2), is(9999));

    }

    @Test
    public void getValueByIndex() {
        assertThat(integers.get(0), is(64));
        assertThat(integers.get(1), is(100));
        integers.add(29);
        assertThat(integers.get(2), is(29));
    }

    @Test
    public void whenHasNextReturnTrue() {
        assertThat(it.hasNext(), is(true));

    }

    @Test
    public void whenIteratorNextReturnValeu() {
        assertThat(it.next(), is(64));
    }


}