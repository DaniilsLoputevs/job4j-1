package ru.job4j.storeauto.store;

import java.util.List;

public interface Store<T> {

    void add(T value);

    void replace(T value);

    void delete(T value);

    List<T> findAll();

}
