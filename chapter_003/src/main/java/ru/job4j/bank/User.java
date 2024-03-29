package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 10.02.19
 */
public class User {

    private String name;
    private String passport;


    public User() {
    }


    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                &&
                Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='"
                +
                name + '\''
                +
                ", passport='"
                +
                passport + '\''
                +
                '}';
    }
}


