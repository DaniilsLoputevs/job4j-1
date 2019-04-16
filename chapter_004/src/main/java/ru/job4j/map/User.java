package ru.job4j.map;

import java.util.Calendar;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 15.04.2019
 */
public class User {
    private String name;
    private int child;
    private Calendar birth;

    /**
     * Конструктор для инициализации обьекта User
     *
     * @param name  Имя
     * @param child Количество детей
     * @param birth Дата рождения
     */
    public User(String name, int child, Calendar birth) {
        this.name = name;
        this.child = child;
        this.birth = birth;
    }

    public Calendar getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='"
                + name + '\''
                +
                ", child="
                + child
                +
                '}';
    }
}
