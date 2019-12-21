package ru.job4j.servletapi.crud;

import javax.servlet.http.HttpServletRequest;


public class Extract {

    static User extracting(HttpServletRequest request) {
        User user = new User(request.getParameter("id"), request.getParameter("name"), request.getParameter("login"), request.getParameter("email"));
        return user;

    }
}
