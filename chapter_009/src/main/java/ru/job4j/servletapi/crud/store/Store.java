package ru.job4j.servletapi.crud.store;


import ru.job4j.servletapi.crud.models.User;

import java.util.Collection;

public interface Store {

    void add(User user);

    boolean update(String id, User user);

    boolean delete(User user);

    User findById(String id);

    Collection<User> findAll();
}
