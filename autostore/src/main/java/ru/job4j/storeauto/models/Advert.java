package ru.job4j.storeauto.models;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "advert")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private String price;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Advert() {
    }

    public Advert(String title, String price, Car car) {
        this.title = title;
        this.price = price;
        this.car = car;
    }


    public Integer getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Advert advert = (Advert) o;
        return Objects.equals(id, advert.id)
                &&
                Objects.equals(title, advert.title)
                &&
                Objects.equals(price, advert.price)
                &&
                Objects.equals(car, advert.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, car);
    }

    @Override
    public String toString() {
        return "Advert{"
                +
                "id="
                + id
                +
                ", title='"
                + title + '\''
                +
                ", price='"
                + price + '\''
                +
                ", account="
                + car
                +
                '}';
    }
}
