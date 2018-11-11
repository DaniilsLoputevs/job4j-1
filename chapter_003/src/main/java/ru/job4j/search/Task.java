package ru.job4j.search;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 11.11.2018
 */

public class Task {
    private String desc;
    private int priority;

    /**
     * Конструктор класса Task
     *
     * @param desc - описание задачи.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Геттер для поля
     *
     * @return - поле описание задачи.
     */

    public String getDesc() {
        return desc;
    }

    /**
     * Геттер для поля
     *
     * @return - поле приоритет для задачи.
     */
    public int getPriority() {
        return priority;
    }
}
