package ru.job4j.servletapi.crud;

import java.util.Collection;

import java.util.Map;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStore implements Store {
    private static final Store INSTANCE = new MemoryStore();
    private final Map<String, Model> users = new ConcurrentHashMap<>();

    private MemoryStore() {
    }

    public static Store getInstance() {
        return INSTANCE;
    }


    @Override
    public void add(Model model) {
        users.put(model.getId(), model);

    }

    @Override
    public boolean update(String id, Model model) {
        Optional<Model> updated = Optional.ofNullable(users.replace(id, model));
        return updated.isPresent();
    }

    @Override
    public boolean delete(Model model) {
        Optional<Model> removed = Optional.ofNullable(users.remove(model.getId()));
        return removed.isPresent();
    }

    @Override
    public Model findById(String id) {
        return users.get(id);
    }

    @Override
    public Collection<Model> findAll() {
        return users.values();
    }
}


