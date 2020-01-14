package ru.job4j.hibernate.todo.validation;

import ru.job4j.hibernate.todo.model.Item;

import java.util.Collection;

public interface Validate {

    boolean add(Item item);

    boolean replace(Item item);

    boolean delete(Item item);

    Collection<Item> findAll();

}
