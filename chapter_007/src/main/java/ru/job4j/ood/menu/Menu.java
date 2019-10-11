package ru.job4j.ood.menu;

import java.util.List;

public class Menu implements Adding {
    private String title;
    private Submenu submenu;
    private List<Submenu> submenuList;

    public Menu(String title) {
        this.title = title;
    }

    @Override
    public void insertSubMenu(String titlemenu) {
        this.submenu = new Submenu();


    }

    @Override
    public String toString() {
        return "menu{"
                +
                "title='"
                + title
                + '\''
                +
                ", submenu="
                + submenu
                +
                '}';
    }

    private class Submenu implements Adding {
        private String title;
        private List<String> submenu;

        @Override
        public void insertSubMenu(String title) {

        }
    }
}
