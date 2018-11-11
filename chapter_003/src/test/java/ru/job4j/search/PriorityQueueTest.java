package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 11.11.2018
 */


public class PriorityQueueTest {
    /**
     * Тестирование приоритета по задачам вариант 1.
     */
    @Test
    public void whenHighPriority() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("low", 5));
        priorityQueue.put(new Task("urgent", 1));
        priorityQueue.put(new Task("middle", 3));
        Task result = priorityQueue.take();
        assertThat(result.getDesc(), is("urgent"));

    }

    /**
     * Тестирование приоритета по задачам вариант 2
     */
    @Test
    public void whenHightPriority2() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("Бездельничать", 5));
        priorityQueue.put(new Task("Читать худ литературу", 4));
        priorityQueue.put(new Task("Выполнить работу ", 3));
        priorityQueue.put(new Task("Читать теорию по Java", 2));
        priorityQueue.put(new Task("Практиковаться по задачам", 1));
        Task result = priorityQueue.take();
        assertThat(result.getDesc(), is("Практиковаться по задачам"));
    }
}
