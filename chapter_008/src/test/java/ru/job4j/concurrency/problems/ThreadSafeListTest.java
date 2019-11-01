package ru.job4j.concurrency.problems;

import org.junit.Test;
import ru.job4j.list.DynamicList;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ThreadSafeListTest {

    @Test
    public void add() {
        ThreadSafeList<String> val = init();
        val.add("four");
        assertThat(val.get(3), is("four"));
    }

    @Test
    public void get() {
        ThreadSafeList<String> val = init();
        assertThat(val.get(0), is("one"));
        assertThat(val.get(2), is("three"));
    }

    @Test
    public void getSize() {
        ThreadSafeList<String> val = init();
        //autogrow size when size == 3
        assertThat(val.getSize(), is(6));
    }

    @Test
    public void iterator() {
        Iterator<String> it = init().iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("one"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("two"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("three"));
        assertThat(it.hasNext(), is(false));
    }

    private ThreadSafeList<String> init() {
        ThreadSafeList<String> tmp = new ThreadSafeList<>(new DynamicList<>());
        tmp.add("one");
        tmp.add("two");
        tmp.add("three");
        return tmp;
    }
}