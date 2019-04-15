package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    SimpleSet<String> strings;
    Iterator<String> iterator;
    String a;
    String b;
    String c;
    String d;
    String e;

    @Before
    public void init() {
        strings = new SimpleSet<>();
        a = "1";
        b = "12";
        c = "12";
        d = "1";
        e = "45";
        iterator = strings.iterator();
    }

    @Test
    public void addAndReturnTrueValueWhenNotEqualsElementAfterReturnFalse() {
        assertThat(strings.add(a), is(true));
        assertThat(strings.add(b), is(true));
        assertThat(strings.add(c), is(false));
        assertThat(strings.add(d), is(false));
    }

    @Test
    public void testIterator() {
        strings.add(a);
        strings.add(b);
        strings.add(e);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("12"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("45"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void testWithNull() {
        assertThat(strings.add(null), is(true));
    }
}