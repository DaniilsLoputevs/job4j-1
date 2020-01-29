package ru.job4j.storeauto.validate;

import ru.job4j.storeauto.dao.AccountsDao;
import ru.job4j.storeauto.dao.CarsDao;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.models.Car;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class ValidateAccount implements Validation<Account> {
    private final static AccountsDao INSTANCE = AccountsDao.getINSTANCE();
    private final static ValidateAccount VALIDATE_DATA = new ValidateAccount();

    private ValidateAccount() {
    }


    @Override
    public Account add(Account value) {
        if (checkModel(value)) {
            INSTANCE.add(value);
        }
        return value;
    }

    @Override
    public boolean replace(Account value) {
        boolean rs = checkModel(value);
        if (rs) {
            INSTANCE.replace(value);
        }
        return rs;
    }

    @Override
    public boolean delete(Account value) {
        boolean rs = checkModel(value);
        if (rs) {
            INSTANCE.delete(value);
        }
        return rs;
    }

    @Override
    public List<Account> findAll() {
        return INSTANCE.findAll();
    }

    public Account find(Account account) {
        List<Account> rs = findAll();
        Optional<Account> f = rs.stream().filter(account1 -> account1.getEmail().equals(account.getEmail()) && account1.getPassword().equals(account.getPassword())).findFirst();
        return f.orElseThrow();
    }

    public static ValidateAccount getValidate() {
        return VALIDATE_DATA;
    }

    private boolean checkModel(Account value) {
        return Objects.nonNull(value.getEmail()) && Objects.nonNull(value.getPassword());
    }


}
