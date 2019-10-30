package ru.job4j.concurrency.problems;

public class DeadlockExpample {
    /**
     * Демонстрация взаимной блокировки двух потоков  , перекрестное обращение к общим ресурсам приводят к заморозке приложения по причине ожидания
     * двух потоков , когда они освободят друг друга.
     *
     * @param args
     * @see "https://www.javatpoint.com/deadlock-in-java"
     */
    public static void main(String[] args) {
        Pojo pojofirst = new Pojo("one");
        Pojo pojosecond = new Pojo("two");

        Thread thread = new Thread(() -> {
            synchronized (pojofirst.value) {
                System.out.println("Thread 1 locked pojofirst");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (pojosecond.value) {
                    System.out.println("Thread 1 locked pojosecond");
                }
            }


        });

        Thread thread2 = new Thread(() -> {
            synchronized (pojosecond.value) {
                System.out.println("Thread 2 locked pojosecond");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (pojofirst.value) {
                    System.out.println("Thread 2 locked pojofirst");
                }
            }


        });
        thread.start();
        thread2.start();

    }
}
