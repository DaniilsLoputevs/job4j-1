package ru.job4j.servletapi.crud;

import java.util.Collection;
import java.util.List;



public interface Validate {

    boolean add(Model model);

    boolean update(Model model);

    boolean delete(Model model);

    Model findById(Model model);

   Collection<Model> findAll();





}
