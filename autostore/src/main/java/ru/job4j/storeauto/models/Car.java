package ru.job4j.storeauto.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "car_model")
    private String title;
    @Column(name = "car_body")
    @Enumerated(EnumType.STRING)
    private CarBody carBody;

    public Car() {
    }

    public Car(String title, CarBody carBody) {
        this.title = title;
        this.carBody = carBody;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String login) {
        this.title = login;
    }


    public CarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(id, car.id)
                &&
                Objects.equals(title, car.title)
                &&
                carBody == car.carBody;
//
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, carBody);
    }

    @Override
    public String toString() {
        return "Car{"
                +
                "id="
                + id
                +
                ", title='"
                + title
                + '\''
                +
                ", carBody="
                + carBody
                +
                '}';
    }
}
