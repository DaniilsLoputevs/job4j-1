package ru.job4j.servletapi.crud;


import java.util.Objects;

public class Role {
    private String rolestrategy;

    public Role(String idrole) {
        this.rolestrategy = idrole;
    }

    public String getIdrole() {
        return rolestrategy;
    }

    public void setIdrole(String idrole) {
        this.rolestrategy = idrole;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(rolestrategy, role.rolestrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolestrategy);
    }

    @Override
    public String toString() {
        return "Role{"
                +
                "rolestrategy='"
                + rolestrategy
                +
                '\''
                +

                '}';
    }
}
