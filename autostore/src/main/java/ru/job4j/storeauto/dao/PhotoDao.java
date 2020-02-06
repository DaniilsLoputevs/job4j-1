package ru.job4j.storeauto.dao;

import ru.job4j.storeauto.hiberutils.FuncSessionOpen;

import ru.job4j.storeauto.models.Photo;
import ru.job4j.storeauto.store.Store;

import java.util.List;

public class PhotoDao implements Store<Photo> {
    private static final PhotoDao INSTANCE = new PhotoDao();

    private PhotoDao() {

    }

    @Override
    public void add(Photo value) {

    }

    @Override
    public void replace(Photo value) {

    }

    @Override
    public void delete(Photo value) {

    }

    @Override
    public List<Photo> findAll() {
        return null;
    }

    @Override
    public Photo findbById(Photo value) {
        return FuncSessionOpen.funcApplyCommand(session -> session.get(Photo.class, value.getId()));
    }

    public static PhotoDao getPhotoDao() {
        return INSTANCE;
    }
}
