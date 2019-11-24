package ru.job4j.servletapi.crud;

import java.util.Collection;



public interface Validate {

    boolean add(Model model);

    boolean update(Model model);

    boolean delete(Model model);

    boolean findById(Model model);

   Collection<Model> findAll();





}
