package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {
    User user;
    User user2;
    Object object;
    Object object1;
    Map<User, Object> map;
    Calendar c1;
    Calendar c2;

    @Before
    public void init() {
        map = new HashMap<>();
        user = new User("Alex", 5, new GregorianCalendar(1989, Calendar.JULY, 22));
        user2 = new User("Alex", 5, new GregorianCalendar(1989, Calendar.JULY, 22));
        object = new Object();
        object1 = new Object();
        map.put(user, object);
        map.put(user2, object);
        c1 = new GregorianCalendar(1989, 1, 22);
        c2 = new GregorianCalendar(1989, 1, 22);

    }

    @Test
    public void testingAddUsersInMapAndCheckSize() {
        assertThat(map.size(), is(2));
    }

    @Test
    public void testingEqualsTwoValue() {
        for (int i = 0; i <= 10; i++) {
            assertThat(user.equals(user2), is(false));
            assertThat(user2.equals(user), is(false));

        }
    }

    @Test
    public void testinSoutValuesInMap() {
        System.out.println(map);
        System.out.println("Значение хэшкода для первого ключа : " + map.get(user).hashCode());
        System.out.println("Значение хэшкода для второго ключа : " + map.get(user2).hashCode());
    }

    @Test
    public void testingTwoCalendarObjects() {
        assertThat(c1.equals(c2), is(true));
    }

}