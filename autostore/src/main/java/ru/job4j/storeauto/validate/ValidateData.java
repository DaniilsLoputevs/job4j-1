package ru.job4j.storeauto.validate;

import ru.job4j.storeauto.dao.AdvertDao;
import ru.job4j.storeauto.models.Advert;

import java.util.List;
import java.util.Objects;


public class ValidateData implements Validation<Advert> {
    private final static AdvertDao INSTANCE = AdvertDao.getINSTANCE();
    private final static ValidateData VALIDATE_DATA = new ValidateData();

    private ValidateData() {
    }


    @Override
    public Advert add(Advert value) {
        if (checkModel(value)) {
            INSTANCE.add(value);
        }
        return value;
    }

    @Override
    public boolean replace(Advert value) {
        boolean rs = checkModel(value);
        if (rs) {
            INSTANCE.replace(value);
        }
        return rs;
    }

    @Override
    public boolean delete(Advert value) {
        boolean rs = checkModel(value);
        if (rs) {
            INSTANCE.delete(value);
        }
        return rs;
    }

    @Override
    public List<Advert> findAll() {
        return INSTANCE.findAll();
    }

    public static ValidateData getValidate() {
        return VALIDATE_DATA;
    }

    private boolean checkModel(Advert value) {
        return Objects.nonNull(value.getPrice()) && Objects.nonNull(value.getTitle());
    }

}
