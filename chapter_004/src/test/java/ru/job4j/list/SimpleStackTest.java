package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<Integer> simpleStack;
    Iterator<Integer> it;

    @Before
    public void init() {
        simpleStack = new SimpleStack<>();
        simpleStack.push(99);
        simpleStack.push(1);
        simpleStack.push(3);
        it = simpleStack.iterator();
    }

    @Test
    public void polValueAndGetTrueValue() {
        assertThat(simpleStack.pol(), is(3));
        assertThat(simpleStack.pol(), is(1));
        assertThat(simpleStack.pol(), is(99));
        assertThat(it.hasNext(), is(false));
        assertThat(simpleStack.isEmpty(), is(true));
    }

    @Test
    public void pushValueAndSecondTestNullValueAndReturnFalse() {
        simpleStack.push(199);
        assertThat(simpleStack.pol(), is(199));
        assertThat(simpleStack.push(null), is(false));
    }

    @Test
    public void isEmpty() {
        simpleStack.pol();
        simpleStack.pol();
        simpleStack.pol();
        assertThat(simpleStack.isEmpty(), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void checkAllValueWithIteratorAndAfterCatchException() {
        Iterator<Integer> test = simpleStack.iterator();
        assertThat(test.next(), is(3));
        assertThat(test.hasNext(), is(true));
        assertThat(test.next(), is(1));
        assertThat(test.hasNext(), is(true));
        assertThat(test.next(), is(99));
        assertThat(test.hasNext(), is(false));
        test.next();


    }
}