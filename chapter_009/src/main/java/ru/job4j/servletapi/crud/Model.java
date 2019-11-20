package ru.job4j.servletapi.crud;

import java.time.LocalDateTime;


public class Model {
    private int id;
    private String name;
    private String login;
    private String email;
    private LocalDateTime localDateTime;

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    public Model(String name, String login, String email, LocalDateTime localDateTime) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.localDateTime = localDateTime;
        this.id = (int) System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Model{"
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
}
