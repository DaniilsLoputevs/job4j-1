package ru.job4j.servletapi.crud;


import java.util.Collection;

public interface Store {

    void add(User user);

    boolean update(String id, User user);

    boolean delete(User user);

    User findById(String id);

    Collection<User> findAll();
}
