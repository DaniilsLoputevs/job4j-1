package ru.job4j.concurrency.problems;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private final Queue<T> queue;
    private final int size;

    public SimpleBlockingQueue(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        System.out.println(queue.size());
    }

    public void offer(T value) {
        synchronized (this) {
            while (queue.size() == size) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(value);
            System.out.println("Занесено значение в очередь " + value);
            notify();

        }

    }

    public T poll() {
        synchronized (this) {
            while (queue.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T rs = queue.poll();
            System.out.println("Выведено из очереди " + rs);
            notify();
            return rs;
        }
    }


    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue(5);
        Thread a = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                queue.offer(i);
            }
        });

        Thread b = new Thread(() -> {
            while (true) {
                System.out.println("Тред " + Thread.currentThread().getName());
                queue.poll();

            }
        });
        b.start();
        a.start();

    }

}
