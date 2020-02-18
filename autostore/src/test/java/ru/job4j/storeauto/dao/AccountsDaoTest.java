package ru.job4j.storeauto.dao;

import org.junit.Test;
import ru.job4j.storeauto.models.Account;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class AccountsDaoTest {
    private AccountsDao accountsDao = AccountsDao.getINSTANCE();


    @Test
    public void addNewValueAndReplace() {
        Account replaced = accountsDao.add(new Account("olddata", "olddata"));
        replaced.setPassword("newdata");
        accountsDao.replace(replaced);
        Account actual = accountsDao.findbById(replaced);
        assertThat(actual.getPassword(), is("newdata"));
    }

    @Test
    public void delete() {
        Account deleted = accountsDao.add(new Account("test2", "test2"));
        accountsDao.delete(deleted);
        assertThat(accountsDao.findAll().size(), is(0));
    }

    @Test
    public void findAll() {
        int size = accountsDao.findAll().size();
        accountsDao.add(new Account("findall", "findall"));
        assertThat(accountsDao.findAll().size(), is(size + 1));

    }

    @Test
    public void findbById() {
        Account finded = accountsDao.add(new Account("findByID", "findByID"));
        assertThat(accountsDao.findbById(finded).getEmail(), is("findByID"));
    }

    @Test
    public void addNewAccountAndCheckAllFields() {
        Account account = accountsDao.add(new Account("checkfield", "checkfield"));
        assertThat(account.getId(), notNullValue());
        assertThat(account.getEmail(), is("checkfield"));
        assertThat(account.getPassword(), is("checkfield"));
    }
}