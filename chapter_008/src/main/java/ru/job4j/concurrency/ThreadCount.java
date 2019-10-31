package ru.job4j.concurrency;

public class ThreadCount extends Thread {
    private final Count count;

    public ThreadCount(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        count.increment();
    }
}
