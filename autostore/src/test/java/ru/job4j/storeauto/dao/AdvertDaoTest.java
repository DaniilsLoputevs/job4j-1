package ru.job4j.storeauto.dao;

import org.junit.Test;
import ru.job4j.storeauto.models.*;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class AdvertDaoTest {
    private AdvertDao advertDao = AdvertDao.getINSTANCE();
    private AccountsDao accountsDao = AccountsDao.getINSTANCE();


    @Test
    public void add() {
        Account account = new Account("accounttest", "accounttest");
        Advert advert = new Advert("selltest", "500", new Car("testcar", "testvincode", CarBody.Coupe));
        Account added = accountsDao.add(account);
        advert.setAccount(added);
        Advert actual = advertDao.add(advert);
        assertThat(actual.getPrice(), is("500"));
        assertThat(actual.getTitle(), is("selltest"));
        assertThat(actual.getCar().getTitle(), is("testcar"));
        assertThat(actual.getCar().getCarBody(), is(CarBody.Coupe));
        assertThat(actual.getId(), is(notNullValue()));
    }

    @Test
    public void replace() {
        Advert advert = advertDao.findAll().stream().findAny().orElseThrow();
        advert.setTitle("replace");
        advertDao.replace(advert);
        assertThat(advertDao.findbById(advert).getTitle(), is("replace"));
    }

    @Test
    public void delete() {
        int size = advertDao.findAll().size();
        Account account = new Account("accounttest2", "accounttest2");
        Advert advert = new Advert("selltest2", "5000", new Car("testcar2", "testvincode2", CarBody.Estate));
        accountsDao.add(account);
        advert.setAccount(account);
        advertDao.add(advert);
        advertDao.delete(advert);
        assertThat(advertDao.findAll().size(), is(size));

    }

    @Test
    public void findAll() {
        int size = advertDao.findAll().size();
        Advert advert = new Advert("selltest3", "5", new Car("testcar3", "testvincode3", CarBody.Estate));
        Account account = new Account("account", "account");
        accountsDao.add(account);
        advert.setAccount(account);
        advertDao.add(advert);
        assertThat(advertDao.findAll().size(), is(size + 1));
    }

    @Test
    public void findbById() {
        Account account = new Account("advertfindbyid", "advertfindbyid");
        Advert advert = new Advert("adverttitle", "9000", new Car("BMW", "vincode", CarBody.Roadster));
        account = accountsDao.add(account);
        advert.setAccount(account);
        advert = advertDao.add(advert);
        Advert actual = advertDao.findbById(advert);
        assertThat(actual.getId(), is(notNullValue()));
        assertThat(actual.getTitle(), is("adverttitle"));
        assertThat(actual.getPrice(), is("9000"));
        assertThat(actual.getCar().getTitle(), is("BMW"));
        assertThat(actual.getCar().getVincode(), is("vincode"));
        assertThat(actual.getCar().getCarBody(), is(CarBody.Roadster));

    }

    @Test
    public void findOnlyWithPhoto() {
        Account account = new Account("advertswithPhoto", "advertsWithPhoto");
        Advert advert = new Advert("withPhoto", "5000", new Car("Lada", "test", CarBody.Hatchback));
        account = accountsDao.add(account);
        advert.setAccount(account);
        Photo photo = new Photo();
        photo.setFilename("test.jpg");
        photo.setPath("/test/test");
        advert.setPhoto(photo);
        advertDao.add(advert);
        assertThat(advertDao.findOnlyWithPhoto().size(), is(1));
    }
}