package ru.job4j.storeauto.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.storeauto.hiberutils.FuncSessionOpen;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.store.Store;

import java.util.List;

public class AccountsDao implements Store<Account> {
    private final Logger logger = LoggerFactory.getLogger(AccountsDao.class);
    private static final AccountsDao INSTANCE = new ru.job4j.storeauto.dao.AccountsDao();

    private AccountsDao() {
    }

    @Override
    public Account add(Account value) {
        return FuncSessionOpen.funcApplyCommand(session -> {
             session.save(value);
             return value;
         });

    }

    @Override
    public Account replace(Account value) {
        return FuncSessionOpen.funcApplyCommand(session -> {
             session.update(value);
             return value;
         });

    }

    @Override
    public Account delete(Account value) {
        return FuncSessionOpen.funcApplyCommand(session -> {
             session.delete(value);
             return value;
         });

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Account> findAll() {
        return FuncSessionOpen.funcApplyCommand(session -> session.createQuery("from ACCOUNTS ").list());
    }

    @Override
    public Account findbById(Account value) {
        return FuncSessionOpen.funcApplyCommand(session -> session.get(Account.class, value.getId()));
    }


    public static AccountsDao getINSTANCE() {
        return INSTANCE;
    }


}


