package ru.job4j.servletapi.crud.servlets;

import ru.job4j.servletapi.crud.Validate;
import ru.job4j.servletapi.crud.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ValidateStub implements Validate {
    private final Map<String, User> map = new HashMap<>();
    private int id = 0;

    public ValidateStub() {
    }

    @Override
    public boolean add(User user) {
        String ids = null;
        ids = String.valueOf(this.id++);
        user.setId(ids);
        this.map.put(user.getId(), user);
        return false;
    }

    @Override
    public boolean update(User user) {
        this.map.replace(user.getId(), user);
        return true;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean findById(User user) {
        return false;
    }

    @Override
    public Collection<User> findAll() {
        return new ArrayList<User>(this.map.values());
    }
}
