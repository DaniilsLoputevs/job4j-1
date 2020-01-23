package ru.job4j.storeauto.models;

import java.util.List;
import java.util.Objects;

public class User {
    private String id;
    private String login;
    private String password;
    private List<Advert> advertList;

    public User() {
    }

    public User(String login, String password, List<Advert> advertList) {
        this.login = login;
        this.password = password;
        this.advertList = advertList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
        User user = (User) o;
        return Objects.equals(id, user.id)
                &&
                Objects.equals(login, user.login)
                &&
                Objects.equals(password, user.password)
                &&
                Objects.equals(advertList, user.advertList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, advertList);
    }
}
