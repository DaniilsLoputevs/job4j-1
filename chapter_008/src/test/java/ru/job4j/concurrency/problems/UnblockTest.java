package ru.job4j.concurrency.problems;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UnblockTest {

    @Test
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ar = new AtomicReference<>();
        Thread a = new Thread(() -> {
            try {
                throw new RuntimeException("Throw in Thread");
            } catch (Exception e) {
                ar.set(e);
            }
        });
        a.start();
        a.join();
        assertThat(ar.get().getMessage(), is("Throw in Thread"));
    }

    @Test
    public void add() throws InterruptedException {
        Unblock a = new Unblock();
        Thread one = new Thread(() -> {
            a.add(new Base(1, 10));
        });
        Thread two = new Thread(() -> {
            a.add(new Base(2, 10));
        });
        one.start();
        two.start();
        one.join();
        two.join();
        assertThat(a.getMap().size(), is(2));
    }

    @Test
    public void update() throws InterruptedException {
        AtomicReference<Exception> atomicReference = new AtomicReference<>();
        Unblock a = new Unblock();
        a.add(new Base(1, 25));
        Thread one = new Thread(() -> {
            Base changed = new Base(1, 55);
            try {
                a.update(changed);
            } catch (Exception e) {
                atomicReference.set(e);
            }
        });
        Thread two = new Thread(() -> {
            Base changed = new Base(1, 0);
            try {
                a.update(changed);
            } catch (Exception e) {
                atomicReference.set(e);
            }

        });
        one.start();
        one.join();
        two.start();
        two.join();
        assertThat(atomicReference.get().getMessage(), is("OptimisticException"));
    }

    @Test
    public void delete() {
        Unblock a = new Unblock();
        Base test = new Base(45, 1);
        a.add(test);
        a.delete(test);
        assertThat(a.getMap().size(), is(0));
    }
}