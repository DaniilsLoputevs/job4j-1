package ru.job4j.storeauto.dao;


import ru.job4j.storeauto.hiberutils.FuncSessionOpen;
import ru.job4j.storeauto.models.Advert;
import ru.job4j.storeauto.store.Store;

import javax.persistence.Query;
import java.util.List;


public class AdvertDao implements Store<Advert> {
    private final static AdvertDao INSTANCE = new AdvertDao();

    private AdvertDao() {
    }

    public static AdvertDao getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public Advert add(Advert value) {
        Advert added;
        added = FuncSessionOpen.funcApplyCommand(session -> {
            session.save(value);
            return value;
        });
        return added;
    }

    @Override
    public Advert replace(Advert value) {
        Advert replaced;
        replaced = FuncSessionOpen.funcApplyCommand(session -> {
            session.update(value);
            return value;
        });
        return replaced;

    }

    @Override
    public Advert delete(Advert value) {
        Advert deleted;
        deleted = FuncSessionOpen.funcApplyCommand(session -> {
            session.delete(value);
            return value;
        });
        return deleted;

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
        return FuncSessionOpen.funcApplyCommand(session -> session.createNamedQuery("ADVERTS.findAllWithPhoto", Advert.class).list());
    }

    @SuppressWarnings("unchecked")
    public List<Advert> findAdvertsAddedToday() {
        return FuncSessionOpen.funcApplyCommand(session -> session.createNamedQuery("ADVERTS.findAddedToday", Advert.class).list());
    }

    @SuppressWarnings("unchecked")
    public List<Advert> findAdvertsByCarModel(String cartitle) {
        return FuncSessionOpen.funcApplyCommand(session -> {
            Query query = session.createNamedQuery("ADVERTS.findByCarModel", Advert.class);
            query.setParameter("title", cartitle);
            return query.getResultList();
        });
    }

}
