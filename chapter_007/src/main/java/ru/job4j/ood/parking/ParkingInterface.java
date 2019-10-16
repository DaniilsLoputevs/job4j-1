package ru.job4j.ood.parking;

public interface ParkingInterface {

    boolean manageParking(Vehicle vehicle);

    int freeplace();

    boolean unplace(String carnumber);
}
