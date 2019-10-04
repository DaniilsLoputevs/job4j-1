package ru.job4j.ood.warehouse.template;

import java.time.LocalDate;

public abstract class Food {
    private String title;
    private LocalDate expireDate;
    private LocalDate createDate;
    private int price;
    private int discount;

    public Food(String title, LocalDate expireDate, LocalDate createDate, int price, int discount) {
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
