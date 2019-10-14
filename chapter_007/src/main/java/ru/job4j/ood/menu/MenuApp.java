package ru.job4j.ood.menu;


import ru.job4j.ood.menu.interfaces.Adding;
import ru.job4j.ood.menu.interfaces.AddingSub;
import ru.job4j.ood.menu.interfaces.MenuChoise;

import java.util.*;

public class MenuApp implements Adding, AddingSub, MenuChoise {
    private List<Parentmenu> parentmenuList;

    public MenuApp() {
        this.parentmenuList = new LinkedList<>();
    }

    /**
     * Добавление родительского пункта меню
     *
     * @param title - Название меню.
     */
    @Override
    public void insertParent(String title) {
        Parentmenu parentmenu = new Parentmenu(title);
        parentmenuList.add(parentmenu);
    }

    /**
     * Добавление дочернего меню используя stream и filter .
     *
     * @param parenttitle название родительского меню.
     * @param subtitle    название дочернего меню.
     */
    @Override
    public void insertChildMenu(String parenttitle, String subtitle) {
        parentmenuList.stream().filter(parentmenu -> parentmenu.getName().equals(parenttitle)).forEach(parentmenu -> parentmenu.getChildmenus().add(new Childmenu(subtitle)));


    }


    public List<Parentmenu> getParentmenuList() {
        return parentmenuList;
    }

    /**
     * Метод отображения списка меню.
     */
    public void show() {
        parentmenuList.stream().forEach(System.out::println);
    }

    /**
     * Поиск конкретного пункта меню
     * @param title Название искомоого меню
     * @return
     */
    @Override
    public String getMenuPoint(String title) {
        String rs = null;
        for (Parentmenu parentmenu : parentmenuList) {
            if (parentmenu.getName().equals(title)) {
                rs = parentmenu.getName();
                break;
            }
            for (Childmenu childmenu : parentmenu.getChildmenus()) {
                if (childmenu.getName().equals(title)) {
                    rs = childmenu.getName();
                    break;
                }
            }
        }
        return rs;

    }
}
