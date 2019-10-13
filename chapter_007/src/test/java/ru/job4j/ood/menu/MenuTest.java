package ru.job4j.ood.menu;

import org.junit.Test;

public class MenuTest {

    @Test
    public void insertSubMenu() {
        Menu menu = new Menu("Список задач");
        menu.insertParent("1.Задача");
    }
}