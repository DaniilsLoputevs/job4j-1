package ru.job4j.ood.parking;

import java.util.Objects;

public class Auto implements Vehicle {
    private int sizeplace;
    private String number;

    public Auto(String carnumber, int sizeplace) {
        this.sizeplace = sizeplace;
        this.number = carnumber;
    }

    @Override
    public int findplace() {
        return sizeplace;
    }

    @Override
    public String numberCar() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Auto auto = (Auto) o;
        return sizeplace == auto.sizeplace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeplace);
    }
}
