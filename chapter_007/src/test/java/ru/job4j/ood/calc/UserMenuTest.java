package ru.job4j.ood.calc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserMenuTest {

    @Test
    public void testMenuRange() {
        UserMenu userMenu = new UserMenu();
        assertThat(userMenu.getActions().size(), is(6));
    }

    @Test
    public void isWork() {
        UserMenu userMenu = new UserMenu();
        assertThat(userMenu.isWork(), is(true));
    }
}