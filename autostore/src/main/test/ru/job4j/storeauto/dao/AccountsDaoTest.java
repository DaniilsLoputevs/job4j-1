package ru.job4j.storeauto.dao;

import org.hibernate.cfg.Configuration;
import org.junit.Test;
import ru.job4j.storeauto.models.Account;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AccountsDaoTest {


    @Test
    public void add() {
        Configuration configuration = new Configuration().configure(AccountsDao.class.getClassLoader().getResource("hibernate2.cfg.xml"));
        AccountsDao accountsDao = AccountsDao.getINSTANCE();
        accountsDao.add(new Account("login","password"));
        assertThat(accountsDao.findAll().iterator().next(),is(new Account("login","password")));
    }

    @Test
    public void replace() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findbById() {
    }
}