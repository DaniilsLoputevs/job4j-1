package ru.job4j.hibernate.todo.storage;

import ru.job4j.hibernate.todo.model.Item;

import java.util.Collection;

public interface Store {

    Item add(Item item);

    void replace(Item item);

    Collection<Item> findAll();

    void delete(Item item);

    Item findById(Item item);

}
