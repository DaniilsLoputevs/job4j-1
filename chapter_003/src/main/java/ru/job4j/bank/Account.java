package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 11.02.2019
 */
public class Account {

    private String requisites;
    private double value;

    public Account() {
    }

    public Account(int value, String requisites) {
        this.requisites = requisites;
        this.value = value;
    }

    public Account(String requisites) {
        this.requisites = requisites;
    }


    public void addValueinAccount(double money) {
        this.value += money;
    }

    public void subValueinAccount(double money) {
        this.value -= money;
    }


    public String getRequisites() {
        return requisites;
    }

    public double getValue() {
        return value;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return value == account.value
                &&
                Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites, value);
    }

    @Override
    public String toString() {
        return "Account{"
                +
                "requisites='"
                + requisites + '\''
                +
                ", value="
                + value
                +
                '}';
    }
}
