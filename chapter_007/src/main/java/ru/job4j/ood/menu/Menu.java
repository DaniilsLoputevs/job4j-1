package ru.job4j.ood.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Menu implements Adding {
    private String title;
    private Submenu submenu;
    private Map<String, List<Submenu>> submenuListMap;

    public Menu(String title) {
        this.title = title;
        this.submenuListMap = new TreeMap<>(String::compareTo);
    }

    @Override
    public void insertParent(String titlemenu) {
        submenu = new Submenu(title);
        submenuListMap.put(submenu.title, new ArrayList<>());

    }

    public Map<String, List<Submenu>> getSubmenuListMap() {
        return submenuListMap;
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

    private class Submenu implements AddingSub {
        private String title;
        private List<String> submenu;

        public Submenu(String title) {
            this.title = title;
        }

        @Override
        public void insertChildMenu(String title) {

        }
    }


}
