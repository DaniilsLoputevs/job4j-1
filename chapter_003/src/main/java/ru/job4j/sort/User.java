package ru.job4j.sort;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 06.11.2018
 */

public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    /**
     * Конструктор класса User реализующий Comparable
     *
     * @param name - Имя.
     * @param age  - Возраст.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.getAge());
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='"
                + name + '\''
                +
                ", age="
                + age
                +
                '}';
    }
}
