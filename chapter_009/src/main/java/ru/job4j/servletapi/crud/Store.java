package ru.job4j.servletapi.crud;

import java.util.List;

public interface Store {

    void add(Model model);

    boolean update(Model model);

    boolean delete(Model model);

    Model findById(int id);

    List<Model> findAll();
}
