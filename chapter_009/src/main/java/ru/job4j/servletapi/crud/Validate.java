package ru.job4j.servletapi.crud;

import java.util.List;

public interface Validate {

    void add(Model model);

    void update(Model model);

    void delete(Model model);

    void findById(Model model);

    List<Model> findAll();

}
