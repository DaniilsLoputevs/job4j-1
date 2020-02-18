package ru.job4j.storeauto.store;

import java.util.List;

public interface Store<T> {

    T  add(T value);

    T replace(T value);

    T delete(T value);

    List<T> findAll();

    T findbById(T value);

}
