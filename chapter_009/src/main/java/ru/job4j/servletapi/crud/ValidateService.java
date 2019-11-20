package ru.job4j.servletapi.crud;

import java.util.Objects;

public class ValidateService implements Validate {
    private static Validate instance;
    private Store store = MemoryStore.getInstance();

    private ValidateService() {

    }

    public static synchronized Validate getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ValidateService();
        }
        return instance;
    }

    @Override
    public void add(Model model) {

    }

    @Override
    public void update(Model model) {

    }

    @Override
    public void delete(Model model) {

    }

    @Override
    public void findById(Model model) {

    }

    @Override
    public void findAll(Model model) {

    }
}
