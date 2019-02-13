package ru.job4j.bank;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void equalsTrue() {
        User user1 = new User("Joi", "32455192Y");
        User user2 = new User("Joi", "32455192Y");
        assertEquals(user1, user2);
    }

    @Test
    public void equalsFalse() {
        User user1 = new User("Anna", "123555b");
        User user2 = new User("Viktor", "123555z");
        assertNotEquals(user1, user2);
    }

    @Test
    public void setName() {
    }

    @Test
    public void setPassport() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void getPassport() {
    }
}