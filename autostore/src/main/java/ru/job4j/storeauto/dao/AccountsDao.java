package ru.job4j.storeauto.dao;

import ru.job4j.storeauto.hiberutils.FuncSessionOpen;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.store.Store;


import java.util.List;
import java.util.Optional;

public class AccountsDao implements Store<Account> {
    private static final AccountsDao INSTANCE = new ru.job4j.storeauto.dao.AccountsDao();

    private AccountsDao() {
    }

    @Override
    public void add(Account value) {
        FuncSessionOpen.funcApplyCommand(session -> session.save(value));

    }

    @Override
    public void replace(Account value) {
        FuncSessionOpen.funcApplyCommand(session -> {
            session.update(value);
            return value;
        });

    }

    @Override
    public void delete(Account value) {
        FuncSessionOpen.funcApplyCommand(session -> {
            session.delete(value);
            return value;
        });

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Account> findAll() {
        return FuncSessionOpen.funcApplyCommand(session -> session.createQuery("from account ").list());
    }


    public static AccountsDao getINSTANCE() {
        return INSTANCE;
    }

}


