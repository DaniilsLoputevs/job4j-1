package ru.job4j.concurrency;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserStorageTest {

    @Test
    public void add() {
        UserStorage storage = initial();
        storage.add(new User(1, 100));
        storage.add(new User(2, 100));
        assertThat((storage.getChm().size()), is(2));
    }

    @Test
    public void update() {
        UserStorage storage = initial();
        storage.add(new User(1, 4));
        User user = new User(1, 52);
        assertThat(storage.update(1, user), is(true));
        assertThat(storage.getChm().size(), is(1));

    }

    @Test
    public void delete() {
        UserStorage storage = initial();
        User user = new User(2, 45);
        storage.add(user);
        assertThat(storage.delete(user), is(true));
    }

    @Test
    public void transfer() {
        UserStorage userStorage = initial();
        User a = new User(1, 200);
        User b = new User(2, 400);
        userStorage.add(a);
        userStorage.add(b);
        assertThat(userStorage.transfer(1, 2, 200), is(true));
        assertThat(b.getAnmount(), is(600));
        assertThat(a.getAnmount(), is(0));

    }

    private UserStorage initial() {
        return new UserStorage();
    }
}