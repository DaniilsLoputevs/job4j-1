package ru.job4j.servletapi.crud;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStore implements Store {
    private static Store instance;
    private final Map<Integer, Model> users = new ConcurrentHashMap<>();

    private MemoryStore() {
    }

    public synchronized static Store getInstance() {
        if (Objects.isNull(instance)) {
            instance = new MemoryStore();
        }
        return instance;
    }

    @Override
    public void add(Model model) {
        users.put(model.getId(), model);

    }

    @Override
    public void update(int id, Model model) {
        Model replace = findById(id);
        users.replace(replace.getId(), model);
    }

    @Override
    public boolean delete(Model model) {
        return false;
    }

    @Override
    public Model findById(int id) {
        return users.get(id);
    }

    @Override
    public Map<Integer, Model> findAll() {
        return users;
    }
}


