package ru.job4j.storeauto.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.validate.ValidateAccount;
import ru.job4j.storeauto.validate.ValidateData;
import ru.job4j.storeauto.validate.Validation;

import static org.junit.Assert.*;
@RunWith(PowerMockRunner.class)
@PrepareForTest({ValidateAccount.class})
public class AddAccountControllerTest {

    @Test
    public void doPost() {
        Validation<Account> validation = new ValidateData();
        PowerMockito.mockStatic(ValidateAccount.class);
        Mockito.spy(ValidateAccount.getValidate());
    }
}