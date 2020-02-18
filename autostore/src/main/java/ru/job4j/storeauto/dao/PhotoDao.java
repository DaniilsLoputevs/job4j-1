package ru.job4j.storeauto.dao;

import ru.job4j.storeauto.hiberutils.FuncSessionOpen;

import ru.job4j.storeauto.models.Car;
import ru.job4j.storeauto.models.Photo;
import ru.job4j.storeauto.store.Store;

import java.util.List;

public class PhotoDao implements Store<Photo> {
    private static final PhotoDao INSTANCE = new PhotoDao();

    private PhotoDao() {

    }

    @Override
    public Photo add(Photo value) {
        return FuncSessionOpen.funcApplyCommand(session -> {
            session.save(value);
            return value;
        });

    }

    @Override
    public Photo replace(Photo value) {
        return FuncSessionOpen.funcApplyCommand(session -> {
            session.update(value);
            return value;
        });

    }

    @Override
    public Photo delete(Photo value) {
        return FuncSessionOpen.funcApplyCommand(session -> {
            session.delete(value);
            return value;
        });

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Photo> findAll() {
        return FuncSessionOpen.funcApplyCommand(session -> session.createQuery("from car_photo ").list());
    }

    @Override
    public Photo findbById(Photo value) {
        return FuncSessionOpen.funcApplyCommand(session -> session.get(Photo.class, value.getId()));
    }

    public static PhotoDao getPhotoDao() {
        return INSTANCE;
    }
}
