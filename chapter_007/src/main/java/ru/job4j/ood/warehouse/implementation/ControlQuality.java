package ru.job4j.ood.warehouse.implementation;


import ru.job4j.ood.warehouse.iterfaces.Strategy;
import ru.job4j.ood.warehouse.template.Food;

import java.time.LocalDate;

public class ControlQuality {
    Strategy strategy;


    public void check(Food food) {
//        if (this.percent(food.getCreateDate(), food.getExpireDate()) <= 25.0) {
//
//        }
//        if (this.percent(food.getCreateDate(), food.getExpireDate())) {
//
//        }


    }

    private double percent(LocalDate create, LocalDate expired) {
        long period = expired.toEpochDay() - create.toEpochDay();
        System.out.println(period);
        long ends = expired.toEpochDay() - LocalDate.now().toEpochDay();
        System.out.println(ends);
        double rs = (double) ends / period * 100;
        return rs;
    }


    public static void main(String[] args) {
        ControlQuality controlQuality = new ControlQuality();
        System.out.println(controlQuality.percent(LocalDate.of(2019, 10, 1), LocalDate.of(2019, 10, 31)));
    }

}
