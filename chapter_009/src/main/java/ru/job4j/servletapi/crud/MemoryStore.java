package ru.job4j.servletapi.crud;

import java.util.Collection;

import java.util.Map;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStore implements Store {
    private static final Store INSTANCE = new MemoryStore();
    private final Map<String, User> users = new ConcurrentHashMap<>();

    private MemoryStore() {
    }

    public static Store getInstance() {
        return INSTANCE;
    }


    @Override
    public void add(User user) {
        users.put(user.getId(), user);

    }

    @Override
    public boolean update(String id, User user) {
        Optional<User> updated = Optional.ofNullable(users.replace(id, user));
        return updated.isPresent();
    }

    @Override
    public boolean delete(User user) {
        Optional<User> removed = Optional.ofNullable(users.remove(user.getId()));
        return removed.isPresent();
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public Collection<User> findAll() {
        return users.values();
    }
}


