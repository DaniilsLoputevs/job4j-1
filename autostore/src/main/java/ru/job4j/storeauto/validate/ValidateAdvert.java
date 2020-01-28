package ru.job4j.storeauto.validate;

import ru.job4j.storeauto.dao.AccountsDao;
import ru.job4j.storeauto.dao.AdvertDao;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.models.Advert;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class ValidateAdvert implements Validation<Advert> {
    private final static AdvertDao INSTANCE = AdvertDao.getINSTANCE();
    private final static ValidateAdvert VALIDATE_DATA = new ValidateAdvert();

    private ValidateAdvert() {
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

    public Advert find(Advert advert) {
        List<Advert> rs = findAll();
        Optional<Advert> f = rs.parallelStream().filter(advert1 -> advert1.getId().equals(advert.getId())).findFirst();
        return f.orElseThrow();
    }

    public static ValidateAdvert getValidate() {
        return VALIDATE_DATA;
    }

    private boolean checkModel(Advert value) {
        return Objects.nonNull(value.getPrice()) && Objects.nonNull(value.getTitle());
    }

}
