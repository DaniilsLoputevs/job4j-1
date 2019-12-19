package ru.job4j.servletapi.crud;

import java.time.LocalDateTime;
import java.util.Objects;


public class User {
    private String id;
    private String name;
    private String login;
    private String email;
    private String photoid;

    private LocalDateTime localDateTime;
    public User(String id, String name, String login, String email, LocalDateTime localDateTime) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.localDateTime = localDateTime;
    }

    public User(String id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.localDateTime = LocalDateTime.now();
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    @Override
    public String toString() {
        return "User{"
                +
                "id="
                + id
                +
                ", name='"
                + name
                + '\''
                +
                ", login='"
                + login
                + '\''
                +
                ", email='"
                + email
                + '\''
                +
                ", localDateTime="
                + localDateTime
                +
                '}';
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
        return id == user.id
                &&
                Objects.equals(name, user.name)
                &&
                Objects.equals(login, user.login)
                &&
                Objects.equals(email, user.email)
                &&
                Objects.equals(localDateTime, user.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, localDateTime);
    }
}
