package ru.job4j.storeauto.validate;

import ru.job4j.storeauto.dao.CarsDao;
import ru.job4j.storeauto.models.Car;

import java.util.List;
import java.util.Objects;


public class ValidateCar implements Validation<Car> {
    private final static CarsDao INSTANCE = CarsDao.getINSTANCE();
    private final static ValidateCar VALIDATE_DATA = new ValidateCar();

    private ValidateCar() {
    }


    @Override
    public Car add(Car value) {
        if (checkModel(value)) {
            INSTANCE.add(value);
        }
        return value;
    }

    @Override
    public boolean replace(Car value) {
        boolean rs = checkModel(value);
        if (rs) {
            INSTANCE.replace(value);
        }
        return rs;
    }

    @Override
    public boolean delete(Car value) {
        boolean rs = checkModel(value);
        if (rs) {
            INSTANCE.delete(value);
        }
        return rs;
    }

    @Override
    public List<Car> findAll() {
        return INSTANCE.findAll();
    }

    public static ValidateCar getValidate() {
        return VALIDATE_DATA;
    }

    private boolean checkModel(Car value) {
        return Objects.nonNull(value.getTitle()) && Objects.nonNull(value.getCarBody());
    }

}
