package ru.job4j.ood.warehouse.template;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Food {
    private String title;
    private LocalDate expireDate;
    private LocalDate createDate;
    private BigDecimal price;
    private BigDecimal discount;

    public Food(String title, LocalDate expireDate, LocalDate createDate, BigDecimal price, BigDecimal discount) {
        this.title = title;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "{"
                +
                "title='"
                + title
                + '\''
                +
                ", expireDate="
                + expireDate
                +
                ", createDate="
                + createDate
                +
                ", price="
                + price
                +
                ", discount="
                + discount
                +
                '}';
    }
}
