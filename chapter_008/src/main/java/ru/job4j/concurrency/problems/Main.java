package ru.job4j.concurrency.problems;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        First first = new First(0);
        for (int i = 0; i < 200; i++) {
            MyThread myThread = new MyThread(first);
            myThread.start();
        }
        Thread.sleep(1000);
        System.out.println("Counter " + first.count);
    }
}
