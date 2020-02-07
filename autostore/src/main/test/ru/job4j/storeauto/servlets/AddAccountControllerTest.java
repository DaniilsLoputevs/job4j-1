package ru.job4j.storeauto.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.validate.ValidateAccount;
import ru.job4j.storeauto.validate.ValidateAccountStub;
import ru.job4j.storeauto.validate.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ValidateAccount.class})
public class AddAccountControllerTest {

    @Test
    public void doPost() throws ServletException, IOException {
        Validation<Account> validation = new ValidateAccountStub();
        PowerMockito.mockStatic(ValidateAccount.class);
        Mockito.when(ValidateAccount.getValidate()).thenReturn(validation);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Account account = new Account("root", "root");
        Account find = new Account();
        find.setId(1);
        String val = objectMapper.writeValueAsString(account);
        System.out.println(val);
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(val)));
        new AddAccountController().doPost(request, response);
        assertThat(validation.find(find), is(new Account(1, "root", "root")));

    }

}