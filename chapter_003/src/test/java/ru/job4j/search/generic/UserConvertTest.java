package ru.job4j.search.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserConvertTest {
    @Test
    public void whenProcessListUsers() {
        UserConvert userConvert = new UserConvert();
        User user = new User(0, "Sergey", "Spb");
        User user1 = new User(1, "James", "Spb");
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        Map<Integer, User> hashMap = new HashMap<>();
        hashMap.put(user.getId(), user);
        hashMap.put(user1.getId(), user1);
        assertThat(userConvert.process(users), is(hashMap));
    }

}