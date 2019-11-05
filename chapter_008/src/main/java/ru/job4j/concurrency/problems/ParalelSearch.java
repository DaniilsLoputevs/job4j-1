package ru.job4j.concurrency.problems;


public class ParalelSearch {
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(10);
        final Thread consumer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println(queue.poll());
                } catch (Exception e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        consumer.start();

        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                queue.offer(i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            consumer.interrupt();
        }).start();

    }
}
