package ru.job4j.servletapi.crud;

import ru.job4j.servletapi.crud.models.Role;
import ru.job4j.servletapi.crud.models.User;

import javax.servlet.http.HttpServletRequest;


public class Extract {

   public static User extractingUser(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String roleStrat = request.getParameter("role");
        return new User(id, name, login, email, new Role(roleStrat));
    }

}
