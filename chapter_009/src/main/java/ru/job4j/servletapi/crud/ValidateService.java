package ru.job4j.servletapi.crud;

import java.util.*;

public class ValidateService implements Validate {
    private static final Validate INSTANCE = new ValidateService();
    private final Store store = MemoryStore.getInstance();

    private ValidateService() {

    }

    public static Validate getInstance() {
        return INSTANCE;
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
        Optional<Model> finded = Optional.of(store.findById(model.getId()));
        return store.update(finded.get().getId(), model);
    }

    @Override
    public boolean delete(Model model) {
        Optional<Model> finded = Optional.ofNullable(store.findById(model.getId()));
        finded.ifPresent(model1 -> store.delete(model));
        return finded.isPresent();

    }

    @Override
    public boolean findById(Model model) {
        Optional<Model> finded = Optional.ofNullable(store.findById(model.getId()));
        return finded.isPresent();
    }

    @Override
    public Collection<Model> findAll() {

        return store.findAll();

    }
}
