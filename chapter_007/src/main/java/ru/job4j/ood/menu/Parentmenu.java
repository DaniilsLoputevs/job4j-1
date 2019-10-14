package ru.job4j.ood.menu;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Parentmenu implements Comparable<Parentmenu> {
    private String name;
    private List<Childmenu> childmenus;

    public Parentmenu(String name) {
        this.name = name;
        this.childmenus = new ArrayList<>();
    }

    public List<Childmenu> getChildmenus() {
        return childmenus;
    }


    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Parentmenu parentmenu) {
        return this.name.compareTo(parentmenu.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parentmenu that = (Parentmenu) o;
        return name.equals(that.name)
                &&
                childmenus.equals(that.childmenus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, childmenus);
    }

    @Override
    public String toString() {
        return "Parentmenu{"
                +
                "name='"
                + name
                + '\''
                +
                ", childmenus="
                + childmenus
                +
                '}';
    }
}
