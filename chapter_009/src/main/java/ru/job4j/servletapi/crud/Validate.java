package ru.job4j.servletapi.crud;

public interface Validate {

    void add(Model model);

    void update(Model model);

    void delete(Model model);

    void findById(Model model);

    void findAll(Model model);

}
