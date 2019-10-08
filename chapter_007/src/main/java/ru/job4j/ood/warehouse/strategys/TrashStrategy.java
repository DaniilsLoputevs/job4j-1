package ru.job4j.ood.warehouse.strategys;

import ru.job4j.ood.warehouse.iterfaces.Strategy;
import ru.job4j.ood.warehouse.template.Food;

import java.time.LocalDate;

public class TrashStrategy implements Strategy {
    @Override
    public boolean checkState(Food food) {
        double period = food.getExpireDate().toEpochDay() - food.getCreateDate().toEpochDay();
        double endsperiod = (food.getExpireDate().toEpochDay() - LocalDate.now().toEpochDay());
        double rs = (endsperiod / period * 100);
        System.out.println(rs);
        return rs <= 25.0;
    }
}
