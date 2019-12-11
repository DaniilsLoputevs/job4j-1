package ru.job4j.servletapi.crud;

import java.util.*;

public class ValidateService implements Validate {
    private static final Validate INSTANCE = new ValidateService();
    private final Store store = DbStore.getinstance();

    private ValidateService() {

    }

    public static Validate getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean add(User user) {
        boolean rs = false;
        if (Objects.nonNull(user.getName()) && Objects.nonNull(user.getLogin()) && Objects.nonNull(user.getEmail())) {
            rs = true;
            user.setId(user.getId());
            store.add(user);
        }
        return rs;
    }

    @Override
    public boolean update(User user) {
        Optional<User> finded = Optional.of(store.findById(user.getId()));
        return store.update(finded.get().getId(), user);
    }

    @Override
    public boolean delete(User user) {
        Optional<User> finded = Optional.ofNullable(store.findById(user.getId()));
        finded.ifPresent(model1 -> store.delete(user));
        return finded.isPresent();

    }

    @Override
    public boolean findById(User user) {
        Optional<User> finded = Optional.ofNullable(store.findById(user.getId()));
        return finded.isPresent();
    }

    @Override
    public Collection<User> findAll() {

        return store.findAll();

    }
}
