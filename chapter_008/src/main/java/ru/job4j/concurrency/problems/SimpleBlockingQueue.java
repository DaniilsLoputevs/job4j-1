package ru.job4j.concurrency.problems;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue;
    private boolean canWork;

    public SimpleBlockingQueue() {
        this.queue = new LinkedList<>();
        canWork = false;
    }

    public synchronized void offer(T value) {
        while (canWork) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        queue.offer(value);
        canWork = true;
        notify();
        System.out.println("Ввведено значение в очередь " + value);
    }

    public synchronized T poll() {
        T rs = null;
        while (!canWork) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        rs = queue.poll();
        canWork = false;
        notify();
        System.out.println("Значение из очереди " + rs);
        return rs;
    }

    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread a = new Thread(() -> {
            while (true) {
                int i = 1;
                queue.offer(i++);

            }
        });
        Thread b = new Thread(() -> {
            while (true) {
                System.out.println(queue.poll());
            }
        });
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
