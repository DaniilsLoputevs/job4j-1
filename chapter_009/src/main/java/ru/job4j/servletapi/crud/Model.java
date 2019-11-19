package ru.job4j.servletapi.crud;

import java.time.LocalDateTime;

public class Model {
    private int id;
    private String name;
    private String login;
    private String email;
    private LocalDateTime localDateTime;

    public Model(String name, String login, String email, LocalDateTime localDateTime) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.localDateTime = localDateTime;
        this.id = 0;
    }
}
