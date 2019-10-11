package ru.job4j.ood.warehouse.template;

import java.time.LocalDate;

public  abstract class RepFood extends Food {
    protected boolean canReprod;

    public RepFood(String title, LocalDate expireDate, LocalDate createDate, int price, int discount, boolean canReprod) {
        super(title, expireDate, createDate, price, discount, canReprod);
        this.canReprod = canReprod;
    }

    public boolean isCanReprod() {
        return canReprod;
    }


}
