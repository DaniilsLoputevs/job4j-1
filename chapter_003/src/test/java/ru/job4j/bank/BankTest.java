package ru.job4j.bank;


import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void addUserComplete() {
        Bank bank = new Bank();
        User user = new User("Andrew", "256666z");
        assertThat(bank.addUser(user), is(true));
    }

    @Test
    public void whenExpectedExeptionsWithDuplicateUser() {
        Bank bank = new Bank();
        User user = new User("Andrew", "256666z");
        bank.addUser(user);
        assertThat(bank.addUser(user), is(false));
    }

    @Test
    public void whenFindUser() {
        Bank bank = new Bank();
        User user = new User("Andrew", "256666z");
        User user2 = new User("An", "256666");
        User user3 = new User("Kol", "2566668");
        bank.addUser(user);
        bank.addUser(user2);
        bank.addUser(user3);
        User expected = user;
        assertThat(bank.findUser("256666z"), is(expected));

    }

    @Test
    public void whenUserNotFind() {
        Bank bank = new Bank();
        User user = new User("Andrew", "256666z");
        bank.addUser(user);
        bank.findUser("514654");
        assertThat(bank.findUser("514654"), is(nullValue()));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user = new User("Andrew", "256666z");
        User user2 = new User("Kol", "2566668");
        bank.addUser(user);
        bank.addUser(user2);
        bank.deleteUser(user2);
        assertThat(bank.findUser("2566668"), is(nullValue()));
    }

    @Test
    public void whenAddNewAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Andrew", "256z");
        bank.addUser(user);
        Account account = new Account(50, "25z");
        bank.addAccountToUser("256z", account);
        Account expected = new Account(50, "25z");
        assertThat(bank.getOneAccount("256z", "25z"), is(expected));
    }

    @Test
    public void whenDeleteAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Andrew", "256z");
        bank.addUser(user);
        Account account = new Account(10, "4566");
        Account account1 = new Account(500, "4522z");
        bank.addAccountToUser("256z", account);
        bank.addAccountToUser("256z", account1);
        bank.deleteAccountFromUser("256z", account);
        assertThat(bank.deleteAccountFromUser("256z", account), is(true));
    }

    @Test
    public void whenTransferMoneyIsPossible() {
        Bank bank = new Bank();
        User user = new User("Leo", "abz4");
        User user2 = new User("Vik", "zyq");
        Account account = new Account(500, "lkjh1");
        Account account2 = new Account(200, "456ghj");
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccountToUser("abz4", account);
        bank.addAccountToUser("zyq", account2);
        boolean result = true;
        assertThat(result, is(bank.transferMoney("abz4", "lkjh1", "zyq", "456ghj", 500)));
    }
}

