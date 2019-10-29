package ru.job4j.concurrency.problems;

public class MyThread extends Thread {
    private First first;

    public MyThread(First first) {
        this.first = first;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            first.increase();
        }
    }


}
