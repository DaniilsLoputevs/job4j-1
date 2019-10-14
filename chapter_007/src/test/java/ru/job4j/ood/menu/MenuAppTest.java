package ru.job4j.ood.menu;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MenuAppTest {

    @Test
    public void insertParent() {
        MenuApp menuApp = new MenuApp();
        menuApp.insertParent("1.Задача");
        menuApp.insertChildMenu("1.Задача", "1.2 Задача");
        List<Childmenu> rs = menuApp.getParentmenuList().get(0).getChildmenus();
        assertThat(rs.get(0), is(new Childmenu("1.2 Задача")));

    }

    @Test
    public void getConcreteMenu() {
        MenuApp menuApp = new MenuApp();
        menuApp.insertParent("1");
        menuApp.insertParent("2");
        menuApp.insertParent("3");
        menuApp.insertChildMenu("1", "1.1");
        menuApp.insertChildMenu("1", "1.2");
        menuApp.insertChildMenu("1", "1.3");
        menuApp.insertChildMenu("2", "2.1");
        assertThat(menuApp.getMenuPoint("1.3"), is("1.3"));
        assertThat(menuApp.getMenuPoint("2"), is("2"));
        assertThat(menuApp.getMenuPoint("2.1"), is("2.1"));

    }


}