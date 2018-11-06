package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование функционала телефонной книги.
 */
public class PhoneDictionaryTest {

    @Test
    public void whenFindKeyByName() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Serg", "Bolshanin", "911", "Saint Petersburg"));
        List<Person> people = phoneDictionary.find("Ser");
        assertThat(people.iterator().next().getSurname(), is("Bolshanin"));

    }

    @Test
    public void whenFindKeyByAdress() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Джавист", "Джавович", "999645", "Канада - Калгари"));
        List<Person> people = phoneDictionary.find("Кан");
        assertThat(people.iterator().next().getAdress(), is("Канада - Калгари"));
    }
}
