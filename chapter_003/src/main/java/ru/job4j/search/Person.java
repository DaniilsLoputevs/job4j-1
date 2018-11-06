package ru.job4j.search;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 23.10.2018
 */
public class Person {
    /**
     * Поля класса Person.
     */

    private String name;
    private String surname;
    private String phone;
    private String adress;

    /**
     * Конструктор класса Person
     *
     * @param name    = Имя.
     * @param surname = Фамилия.
     * @param phone   = Телефон.
     * @param adress  = Адрес.
     */
    public Person(String name, String surname, String phone, String adress) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

}


