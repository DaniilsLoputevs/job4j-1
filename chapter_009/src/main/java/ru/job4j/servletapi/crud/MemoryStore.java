package ru.job4j.servletapi.crud;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MemoryStore implements Store {
    private List<Model> users = new CopyOnWriteArrayList<Model>();

    @Override
    public void add(Model model) {

    }

    @Override
    public boolean update(Model model) {
        return false;
    }

    @Override
    public boolean delete(Model model) {
        return false;
    }

    @Override
    public Model findById(int id) {
        return null;
    }

    @Override
    public List<Model> findAll() {
        return null;
    }
}
