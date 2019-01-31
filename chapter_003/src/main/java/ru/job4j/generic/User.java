package ru.job4j.generic;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 04.12.2018
 */

public class User {
    private Integer id;
    private String name;
    private String city;


    /**
     * Констуктор класса User.
     *
     * @param id   - Ключ пользователя.
     * @param name - Имя пользователя.
     * @param city - Город пользователя.
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

}
