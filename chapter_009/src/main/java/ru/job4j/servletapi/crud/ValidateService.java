package ru.job4j.servletapi.crud;

import java.util.*;

public class ValidateService implements Validate {
    private static Validate instance;
    private final Store store = MemoryStore.getInstance();

    private ValidateService() {

    }

    public static synchronized Validate getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ValidateService();
        }
        return instance;
    }

    @Override
    public boolean add(Model model) {
        boolean rs = false;
        if (Objects.nonNull(model.getName()) && Objects.nonNull(model.getLogin()) && Objects.nonNull(model.getEmail())) {
            rs = true;
            model.setId(model.getId());
            store.add(model);
        }
        return rs;
    }

    @Override
    public boolean update(Model model) {
        boolean rs = false;
        Model find = store.findById(model.getId());
        if (Objects.nonNull(find)) {
            store.update(model.getId(), model);
            rs = true;
        }
        return rs;
    }

    @Override
    public boolean delete(Model model) {
        return true;

    }

    @Override
    public Model findById(Model model) {
        return store.findById(model.getId());
    }

    @Override
    public Collection<Model> findAll() {
        return store.findAll();

    }
}
