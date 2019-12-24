package ru.job4j.servletapi.crud.models;

import java.time.LocalDateTime;
import java.util.Objects;


public class User {
    private String id;
    private String name;
    private String login;
    private String password;
    private String email;
    private Role role;
    private LocalDateTime localDateTime;

    public User(String id, String name, String login, String password, String email, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String id, String name, String login, String email, LocalDateTime localDateTime, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.role = role;
        this.localDateTime = LocalDateTime.now();
    }

    public User(String id, String name, String login, String email, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
