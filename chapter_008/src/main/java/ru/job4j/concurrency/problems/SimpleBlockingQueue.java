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
    private final int size;
    private final Object object = new Object();

    public SimpleBlockingQueue(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        System.out.println(queue.size());
        canWork = false;
    }

    public void offer(T value) {
        synchronized (this) {
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
            System.out.println("Занесено значение в очередь" + value);
        }

    }

    public T poll() {
        T rs = null;
        synchronized (this) {
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
        }
        System.out.println("выведенное из очереди" + rs);
        return rs;
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
                queue.poll();
            }
        });
        b.start();
        a.start();
    }

}
