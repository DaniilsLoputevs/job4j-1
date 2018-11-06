package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 06.11.2018
 */
public class PhoneDictionary {

    private List<Person> persons = new ArrayList<Person>();

    /**
     * Метод добавления карточки.
     *
     * @param person = карточка .
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод поиска по карточкам использую строковый ключ
     *
     * @param key - ключ.
     * @return Возврат динамического массива с найденными карточками людей с учетом введенного ключа.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key) || person.getSurname().contains(key) || person.getPhone().contains(key) || person.getAdress().contains(key)) {
                result.add(person);
            }

        }
        return result;
    }
}


