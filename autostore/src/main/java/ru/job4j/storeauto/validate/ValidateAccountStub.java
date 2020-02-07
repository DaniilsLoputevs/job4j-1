package ru.job4j.storeauto.validate;

import ru.job4j.storeauto.models.Account;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class ValidateAccountStub implements Validation<Account> {
    private final Map<Integer, Account> storage = new HashMap<>();
    private int id = 0;

    public ValidateAccountStub() {
    }


    @Override
    public Account add(Account value) {
        if (checkModel(value)) {
            value.setId(++id);
            storage.put(value.getId(), value);
        }
        return value;
    }

    @Override
    public boolean replace(Account value) {
        boolean rs = checkModel(value);
        if (rs) {
            storage.replace(value.getId(), value);
        }
        return rs;
    }

    @Override
    public boolean delete(Account value) {
        boolean rs = checkModel(value);
        if (rs) {
            storage.remove(value.getId());
        }
        return rs;
    }

    @Override
    public List<Account> findAll() {
        List<Account> rs = (List<Account>) storage.values();
        return rs;
    }

    @Override
    public Account find(Account value) {
        return storage.get(value.getId());
    }

    private boolean checkModel(Account value) {
        return Objects.nonNull(value.getPassword()) && Objects.nonNull(value.getEmail());
    }

}
