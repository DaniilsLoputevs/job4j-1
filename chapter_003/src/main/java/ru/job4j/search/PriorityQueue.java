package ru.job4j.search;

import java.util.LinkedList;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 11.11.2018
 */

public class PriorityQueue {
    /**
     * Связный список обьектов Task.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод добавляет задачу в связанный список с учётом приоритета задачи.
     *
     * @param task - задача
     */
    public void put(Task task) {
        var t = tasks.size();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPriority() >= task.getPriority()) {
                t = i;
                break;
            }
        }
        tasks.add(t, task);
    }

    public Task take() {
        return this.tasks.poll();
    }


}
