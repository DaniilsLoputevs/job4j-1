package ru.job4j.storeauto.dao;

import ru.job4j.storeauto.hiberutils.FuncSessionOpen;
import ru.job4j.storeauto.models.User;
import ru.job4j.storeauto.store.Store;

import java.util.List;

public class UserDao implements Store<User> {
    private static final UserDao INSTANCE = new UserDao();

    private UserDao() {
    }

    @Override
    public void add(User value) {
        FuncSessionOpen.funcApplyCommand(session -> session.save(value));

    }

    @Override
    public void replace(User value) {
        FuncSessionOpen.funcApplyCommand(session -> {
            session.update(value);
            return value;
        });

    }

    @Override
    public void delete(User value) {
        FuncSessionOpen.funcApplyCommand(session -> {
            session.delete(value);
            return value;
        });

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        return FuncSessionOpen.funcApplyCommand(session -> session.createQuery("from User ").list());
    }

    public static UserDao getINSTANCE() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        UserDao dao = UserDao.getINSTANCE();
        dao.add(new User("test", "psw"));

    }
}
