package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingInterface {
    private int autocount;
    private int truckcount;
    private int sumplace;
    private List<Vehicle> parkplace;

    public Parking(int autocount, int truckcount) {
        this.autocount = autocount;
        this.truckcount = truckcount;
        this.sumplace = autocount + truckcount;
        this.parkplace = new ArrayList<>();
    }


    @Override
    public boolean manageParking(Vehicle vehicle) {
        boolean rs = false;
        int sizeplace = vehicle.findplace();
        if (sumplace >= sizeplace) {
            parkplace.add(vehicle);
            sumplace -= sizeplace;
            rs = true;
        }
        return rs;
    }

    public static void main(String[] args) {
        Parking parking = new Parking(1, 1);
        System.out.println(parking.manageParking(new Auto(1)));
        System.out.println(parking.manageParking(new Auto(2)));
    }
}
