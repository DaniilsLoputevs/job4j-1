package ru.job4j.sort;

import org.junit.Test;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тестирование методов класса SortUser .
 */
public class SortUserTest {

    private final SortUser sortUser = new SortUser();
    final List<User> users = List.of(new User("Bob", 19), new User("Ernandes", 29), new User("Alexander", 33), new User("Anna", 5), new User("Viktor", 2));
    final List<User> expected = List.of(new User("Bob", 19), new User("Anna", 5), new User("Viktor", 2), new User("Ernandes", 29), new User("Alexander", 33));



    /**
     * Тестирование метода возврата листа в TreeSet.
     */
    @Test
    public void whenAllBeRight() {
        TreeSet<User> result = new TreeSet<>();
        result.addAll(users);
        assertThat(result, is(sortUser.sort(users)));
    }

    /**
     * Тестирование метода сортировки по длинне имени.
     */
    @Test
    public void whenSortedByLenght() {
        assertThat(sortUser.sortNameLenght(users).toString(), is(expected.toString()));

    }

    /**
     * Тестирование метода сортировки в лексикографическом порядке , если поле имя одинаковое , сортируется по поле возраст.
     */
    @Test
    public void whenSortedByAllField() {

        assertThat(sortUser.sortByAllField(users).toString(), is(sortUser.sortByAllField(expected).toString()));
    }
}