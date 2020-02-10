package ru.job4j.storeauto.dao;


import ru.job4j.storeauto.hiberutils.FuncSessionOpen;
import ru.job4j.storeauto.models.Advert;
import ru.job4j.storeauto.store.Store;

import java.util.List;


public class AdvertDao implements Store<Advert> {
    private final static AdvertDao INSTANCE = new AdvertDao();

    private AdvertDao() {
    }

    public static AdvertDao getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void add(Advert value) {
        FuncSessionOpen.funcApplyCommand(session -> session.save(value));
    }

    @Override
    public void replace(Advert value) {
        FuncSessionOpen.funcApplyCommand(session -> {
            session.update(value);
            return value;
        });

    }

    @Override
    public void delete(Advert value) {
        FuncSessionOpen.funcApplyCommand(session -> {
            session.delete(value);
            return value;
        });

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Advert> findAll() {
        return FuncSessionOpen.funcApplyCommand(session -> session.createQuery("from Advert ").list());
    }


    @Override
    public Advert findbById(Advert value) {
        return FuncSessionOpen.funcApplyCommand(session -> session.get(Advert.class, value.getId()));
    }

    @SuppressWarnings("unchecked")
    public List<Advert> findOnlyWithPhoto() {
        return FuncSessionOpen.funcApplyCommand(session -> session.createQuery("from Advert as u where photo.path!= null ").list());
    }

}
