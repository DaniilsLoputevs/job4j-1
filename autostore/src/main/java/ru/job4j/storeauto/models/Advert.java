package ru.job4j.storeauto.models;


import javax.persistence.*;
import java.io.File;
import java.sql.Timestamp;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "ADVERTS.findAllWithPhoto", query = "from Advert as a where  a.photo.filename!= null and a.photo.path!= null "),
        @NamedQuery(name = "ADVERTS.findAddedToday", query = "from Advert as a where a.added >= current_date "),
        @NamedQuery(name = "ADVERTS.findByCarModel", query = "from Advert as a where car.title =:title ")
}
)
@Entity
@Table(name = "ADVERTS")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @Column(name = "advert_status")
    private boolean status = true;
    @Column(name = "added")
    private Timestamp added;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
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
        return status == advert.status
                &&
                Objects.equals(id, advert.id)
                &&
                Objects.equals(title, advert.title)
                &&
                Objects.equals(price, advert.price)
                &&
                Objects.equals(account, advert.account)
                &&
                Objects.equals(car, advert.car);
    }

    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, account, car, status);
    }

    @Override
    public String toString() {
        return "Advert{"
                +
                "id="
                + id
                +
                ", title='"
                + title
                + '\''
                +
                ", price='"
                + price
                + '\''
                +
                ", account="
                + account
                +
                ", car="
                + car
                +
                ", status="
                + status
                +
                '}';
    }
}

