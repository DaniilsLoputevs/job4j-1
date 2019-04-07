package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyQueueTest {
    MyQueue<Integer> myQueue;
    Iterator<Integer> it;

    @Before
    public void init() {
        myQueue = new MyQueue<>();
        myQueue.push(45);
        myQueue.push(25);
        myQueue.push(11);
        it = myQueue.iterator();
    }

    @Test
    public void chechPush() {
        assertThat(myQueue.push(23), is(true));
        assertThat(myQueue.push(null), is(false));
        assertThat(myQueue.push(33), is(true));
    }


    @Test(expected = NoSuchElementException.class)
    public void pollElementsAndCheckRightReturnValue() {
        assertThat(myQueue.poll(), is(45));
        assertThat(myQueue.poll(), is(25));
        assertThat(myQueue.poll(), is(11));
        myQueue.poll();
    }

    @Test
    public void pushElementInQueueAndCheckIncreaseSize() {
        myQueue.push(99);
        assertThat(myQueue.getSize(), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void checkIteratorforQueue() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(25));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(45));
        assertThat(it.hasNext(), is(false));
        it.next();

    }
}