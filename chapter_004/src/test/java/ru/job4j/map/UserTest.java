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
    User user3;
    User user2;
    User user4;
    Object object;
    Object object2;
    Object object1;
    Object object3;
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
        user3 = new User("Vi", 1, new GregorianCalendar(1989, Calendar.JULY, 22));
        user4 = new User("Vi", 1, new GregorianCalendar(1989, Calendar.JULY, 22));
        object2 = new Object();
        object3 = new Object();

    }

    @Test
    public void testingAddUsersInMapAndCheckSize() {
        assertThat(map.size() == 2, is(false));
        assertThat(map.size() == 1, is(true));
    }

    @Test
    public void testingEqualsTwoValue() {
        for (int i = 0; i <= 10; i++) {
            assertThat(user.equals(user2), is(true));
            assertThat(user2.equals(user), is(true));

        }
    }

    @Test
    public void testinSoutValuesInMap() {
        System.out.println(map);
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
        System.out.println("Значение первого " + object.hashCode());
        System.out.println("Значение второго " + object1.hashCode());
        System.out.println("Получение значения по первому ключу :" + map.get(user).hashCode());
        System.out.println("Получение значения по второму ключу :" + map.get(user2).hashCode());
    }

    @Test
    public void testingTwoCalendarObjects() {
        assertThat(c1.equals(c2), is(true));
    }

    @Test
    public void addAfterOverEqAndHashCode() {
        map.put(user3, object2);
        map.put(user4, object3);
        assertThat(map.get(user4), is(object3));
        assertThat(map.get(user3), is(object3));
    }

}