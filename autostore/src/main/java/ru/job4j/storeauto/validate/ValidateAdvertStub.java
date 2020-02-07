package ru.job4j.storeauto.validate;

import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.models.Advert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class ValidateAdvertStub implements Validation<Advert> {
    private final Map<Integer, Advert> storage = new HashMap<>();
    private int id = 0;

    public ValidateAdvertStub() {
    }


    @Override
    public Advert add(Advert value) {
        if (checkModel(value)) {
            value.setId(++id);
            storage.put(value.getId(), value);
        }
        return value;
    }

    @Override
    public boolean replace(Advert value) {
        boolean rs = checkModel(value);
        if (rs) {
            storage.replace(value.getId(), value);
        }
        return rs;
    }

    @Override
    public boolean delete(Advert value) {
        boolean rs = checkModel(value);
        if (rs) {
            storage.remove(value.getId());
        }
        return rs;
    }

    @Override
    public List<Advert> findAll() {
        return null;
    }

    @Override
    public Advert find(Advert value) {
        return storage.get(value.getId());
    }

    private boolean checkModel(Advert value) {
        return Objects.nonNull(value.getTitle()) && Objects.nonNull(value.getPrice());
    }

}
