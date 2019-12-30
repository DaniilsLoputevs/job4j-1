package ru.job4j.servletapi.crud;

import org.junit.Test;
import ru.job4j.servletapi.crud.models.Role;
import ru.job4j.servletapi.crud.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExtractTest {

    @Test
    public void extractingUser() {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("1");
        when(req.getParameter("name")).thenReturn("root");
        when(req.getParameter("login")).thenReturn("root");
        when(req.getParameter("password")).thenReturn("root");
        when(req.getParameter("email")).thenReturn("root");
        when(req.getParameter("role")).thenReturn("ADMIN");
        User expected = new User("1", "root", "root", "root", Role.ADMIN);
        User result = Extract.extractingUser(req);
        assertEquals(expected, result);

    }

}