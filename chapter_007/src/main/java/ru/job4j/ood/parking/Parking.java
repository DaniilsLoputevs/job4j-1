package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /**
     * Проверка свободного места на парковке и паркует автомобиль
     * @param vehicle - обьекты реализующие интерфейс Vehicle
     * @return true/false .
     */
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

    /**
     * Возвращает свободное место на парковке
     * @return int значение
     */
    @Override
    public int freeplace() {
        return sumplace;
    }

    /**
     * Освобождает место на парковке по номеру автомобиля.
     * @param carnumber номер автомобиля.
     * @return true/false
     */
    @Override
    public boolean unplace(String carnumber) {
        Optional<Vehicle> val = parkplace.stream().filter(vehicle -> vehicle.numberCar().equals(carnumber)).findFirst();
        val.ifPresent(vehicle -> sumplace += vehicle.findplace());
        return parkplace.removeIf(vehicle -> vehicle.numberCar().equals(carnumber));
    }
}
