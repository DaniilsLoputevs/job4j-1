package ru.job4j.servletapi.crud;


import java.util.Map;

public interface Store {

    void add(Model model);

    void update(int id, Model model);

    boolean delete(Model model);

    Model findById(int id);

    Map<Integer, Model> findAll();
}
