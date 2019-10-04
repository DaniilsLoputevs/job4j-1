package ru.job4j.ood.warehouse.template;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Beef extends Food {
    public Beef(String title, LocalDate expireDate, LocalDate createDate, BigDecimal price, BigDecimal discount) {
        super(title, expireDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "Beef:" + super.toString();
    }

}
