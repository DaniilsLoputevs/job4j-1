package ru.job4j.storeauto.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "login", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany()
    List<Advert> advertList = new ArrayList<>();

    public Account(String email, String password, List<Advert> advertList) {
        this.email = email;
        this.password = password;
        this.advertList = advertList;
    }

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Advert> getAdvertList() {
        return advertList;
    }

    public void setAdvertList(List<Advert> advertList) {
        this.advertList = advertList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(id, account.id)
                &&
                Objects.equals(email, account.email)
                &&
                Objects.equals(password, account.password)
                &&
                Objects.equals(advertList, account.advertList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, advertList);
    }

}
