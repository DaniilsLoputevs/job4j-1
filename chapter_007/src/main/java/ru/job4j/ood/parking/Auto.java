package ru.job4j.ood.parking;

public class Auto implements Vehicle {
    private int sizeplace;

    public Auto(int sizeplace) {
        this.sizeplace = sizeplace;
    }

    @Override
    public int findplace() {
        return sizeplace;
    }
}
