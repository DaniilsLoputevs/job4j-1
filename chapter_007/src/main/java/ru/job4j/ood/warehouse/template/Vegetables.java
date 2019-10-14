package ru.job4j.ood.warehouse.template;

import ru.job4j.ood.warehouse.template.Food;

import java.time.LocalDate;

public class Vegetables extends Food {

    public Vegetables(String title, LocalDate expireDate, LocalDate createDate, int price, int discount, boolean canreprod) {
        super(title, expireDate, createDate, price, discount, canreprod);

    }


}
