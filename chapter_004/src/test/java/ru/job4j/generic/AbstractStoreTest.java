package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AbstractStoreTest {

    @Test
    public void addNewElement() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role("669922");
        roleStore.add(role);
        assertThat(roleStore.findById(role.getId()), is(role));
    }

    @Test
    public void replaceElement() {
        UserStore userStore = new UserStore();
        User user = new User("882233");
        User user2 = new User("882234");
        User user3 = new User("88");
        userStore.add(user);
        userStore.add(user2);
        assertThat(userStore.replace(user.getId(), user3), is(true));

    }

    @Test
    public void deleteElement() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role("353535");
        roleStore.add(role);
        boolean rs = true;
        boolean expected = roleStore.delete(role.getId());
        assertThat(rs, is(expected));
    }

    @Test
    public void findById() {
        UserStore userStore = new UserStore();
        User user = new User("4623217");
        User user2 = new User("46232179");
        userStore.add(user);
        userStore.add(user2);
        User expected = userStore.findById(user.getId());
        assertThat(userStore.findById(user.getId()), is(expected));
    }
}