package ru.job4j.concurrency.problems;

public class First {

    public long count;

    public First(long value) {
        this.count = value;
    }

    public synchronized void increase() {
        count++;
    }

}
