package ru.job4j.servletapi.crud;


import java.util.Collection;

public interface Store {

    void add(Model model);

    boolean update(String id, Model model);

    boolean delete(Model model);

    Model findById(String id);

    Collection<Model> findAll();
}
