package ru.job4j.servletapi.crud;

import java.util.Collection;



public interface Validate {

    boolean add(User user);

    boolean update(User user);

    boolean delete(User user);

    boolean findById(User user);

   Collection<User> findAll();





}
