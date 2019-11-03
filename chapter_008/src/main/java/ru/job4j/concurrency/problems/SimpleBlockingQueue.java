package ru.job4j.concurrency.problems;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleBlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();

    public void offer(T value) {

    }

    public T poll() {
        return null;
    }
}
