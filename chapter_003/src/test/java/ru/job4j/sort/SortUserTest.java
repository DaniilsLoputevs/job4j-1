package ru.job4j.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тестирование методов класса SortUser .
 */
public class SortUserTest {

    private final SortUser sortUser = new SortUser();
    private final List<User> users = new ArrayList<>();
    private final List<User> expected = new ArrayList<>();

    @Before
    public void initialArrays() {
        users.add(new User("Bob", 19));
        users.add(new User("Ernandes", 29));
        users.add(new User("Alexander", 33));
        users.add(new User("Anna", 5));
        users.add(new User("Viktor", 2));


    }

    /**
     * Тестирование метода возврата листа в TreeSet.
     */
    @Test
    public void whenAllBeRight() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Bob", 19));
        users.add(new User("Anna", 5));
        users.add(new User("Viktor", 2));
        users.add(new User("Sergey", 29));
        users.add(new User("Andrew", 29));
        TreeSet<User> result = new TreeSet<>();
        result.addAll(users);
        assertThat(result, is(sortUser.sort(users)));
    }

    /**
     * Тестирование метода сортировки по длинне имени.
     */
    @Test
    public void whenSortedByLenght() {
        expected.add(new User("Bob", 19));
        expected.add(new User("Anna", 5));
        expected.add(new User("Viktor", 2));
        expected.add(new User("Ernandes", 29));
        expected.add(new User("Alexander", 33));
        assertThat(sortUser.sortNameLenght(users).toString(), is(expected.toString()));

    }

    /**
     * Тестирование метода сортировки в лексикографическом порядке , если поле имя одинаковое , сортируется по поле возраст.
     */
    @Test
    public void whenSortedByAllField() {
        // добавление обьекта с одинаковым именем , проверка работы сортировке по возврасту.
        users.add(new User("Alexander", 32));

        expected.add(new User("Alexander", 32));
        expected.add(new User("Alexander", 33));
        expected.add(new User("Anna", 5));
        expected.add(new User("Bob", 19));
        expected.add(new User("Ernandes", 29));
        expected.add(new User("Viktor", 2));
        assertThat(sortUser.sortByAllField(users).toString(), is(expected.toString()));
    }
}