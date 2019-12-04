package ru.job4j.servletapi.crud;

import java.time.LocalDateTime;
import java.util.Objects;


public class Model {
    private String id;
    private String name;
    private String login;
    private String email;
    private LocalDateTime localDateTime;

    public Model(String id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.localDateTime = LocalDateTime.now();
    }

    public Model(String id) {
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
        Model model = (Model) o;
        return id == model.id
                &&
                Objects.equals(name, model.name)
                &&
                Objects.equals(login, model.login)
                &&
                Objects.equals(email, model.email)
                &&
                Objects.equals(localDateTime, model.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, localDateTime);
    }
}
