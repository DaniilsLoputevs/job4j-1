package ru.job4j.storeauto.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adverts")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "price")
    private String price;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "users__id")
    private User user;

    public Advert() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
                Objects.equals(price, advert.price)
                &&
                Objects.equals(user, advert.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, user);
    }
}
