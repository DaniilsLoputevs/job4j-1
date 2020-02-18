package ru.job4j.storeauto.dao;

import ru.job4j.storeauto.hiberutils.FuncSessionOpen;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.models.Car;
import ru.job4j.storeauto.models.CarBody;
import ru.job4j.storeauto.store.Store;

import java.util.List;

public class CarsDao implements Store<Car> {
    private static final CarsDao INSTANCE = new CarsDao();

    private CarsDao() {
    }

    @Override
    public Car add(Car value) {
        return FuncSessionOpen.funcApplyCommand(session -> {
            session.save(value);
            return value;
        });

    }

    @Override
    public Car replace(Car value) {
        return FuncSessionOpen.funcApplyCommand(session -> {
              session.update(value);
              return value;
          });

    }

    @Override
    public Car delete(Car value) {
        return FuncSessionOpen.funcApplyCommand(session -> {
            session.delete(value);
            return value;
        });

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> findAll() {
        return FuncSessionOpen.funcApplyCommand(session -> session.createQuery("from Car ").list());
    }

    @Override
    public Car findbById(Car value) {
        return FuncSessionOpen.funcApplyCommand(session -> session.get(Car.class, value.getId()));
    }

    public static CarsDao getINSTANCE() {
        return INSTANCE;
    }


}
