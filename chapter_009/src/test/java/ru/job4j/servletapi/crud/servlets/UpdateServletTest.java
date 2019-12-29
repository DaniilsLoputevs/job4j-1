package ru.job4j.servletapi.crud.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.servletapi.crud.Validate;
import ru.job4j.servletapi.crud.ValidateService;
import ru.job4j.servletapi.crud.models.Role;
import ru.job4j.servletapi.crud.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class UpdateServletTest {

    @Test
    public void whenAdminUpdateUserById() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        validate.add(new User("0", "Petr", "root", "root", "root", Role.ADMIN));
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("action")).thenReturn("update");
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("Serg");
        when(req.getParameter("role")).thenReturn("ADMIN");
        new UpdateServlet().doPost(req, resp);
        assertThat(validate.findAll().iterator().next().getName(), is("Serg"));

    }


}