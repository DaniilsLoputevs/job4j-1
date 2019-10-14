package ru.job4j.ood.menu;


import java.util.Objects;

public class Childmenu implements Comparable<Childmenu> {
    private String name;

    public Childmenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Childmenu childmenu) {
        return this.name.compareTo(childmenu.name);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Childmenu childmenu = (Childmenu) o;
        return Objects.equals(name, childmenu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Childmenu{"
                +
                "name='"
                + name
                + '\''
                +
                '}';
    }
}
