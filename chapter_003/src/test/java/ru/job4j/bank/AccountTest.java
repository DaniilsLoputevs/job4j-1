package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void whenAccountEquals() {
        Account account = new Account(10000, "126");
        Account account2 = new Account(10000, "126");
        assertThat(account.equals(account2), is(true));
    }

    @Test
    public void whenAddValueInAccount() {
        Account account = new Account(10, "123");
        account.addValueinAccount(15);
        assertThat(account.getValue(), is(25.0));
    }

    @Test
    public void whenSubValueInAccount() {
        Account account = new Account(500, "123");
        account.subValueinAccount(499);
        assertThat(account.getValue(), is(1.0));
    }

    @Test
    public void whenSetGetRequisitesInAccount() {
        Account account = new Account();
        account.setRequisites("445522zbv1");
        assertThat(account.getRequisites(), is("445522zbv1"));
    }

    @Test
    public void whenSetGetValueInAccount() {
        Account account = new Account();
        account.setValue(250);
        assertThat(account.getValue(), is(account.getValue()));
    }

}