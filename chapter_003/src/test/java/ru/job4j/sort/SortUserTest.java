package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortUserTest {

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
        System.out.println(result);
        assertThat(result, is(sortUser.sort(users)));
    }

}