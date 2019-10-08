package ru.job4j.ood.warehouse.strategys;

import ru.job4j.ood.warehouse.iterfaces.Strategy;
import ru.job4j.ood.warehouse.template.Food;

import java.time.LocalDate;

public class ShopStrategy implements Strategy {

    @Override
    public boolean checkState(Food food) {
        double period = food.getExpireDate().toEpochDay() - food.getCreateDate().toEpochDay();
        double endsperiod = (food.getExpireDate().toEpochDay() - LocalDate.now().toEpochDay());
        double rs = (endsperiod / period * 100);
        if (rs > 75.0) {
            food.setPrice(food.getPrice() - (food.getPrice() * (food.getDiscount() / 100)));
        }
        return rs >= 25.0 && rs > 75.0;
    }
}
