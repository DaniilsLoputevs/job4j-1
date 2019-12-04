package ru.job4j.servletapi.crud;

import javax.servlet.http.HttpServletRequest;


public class ModelConstruct {

    static Model model(HttpServletRequest request) {
        return new Model(request.getParameter("id"), request.getParameter("name"), request.getParameter("login"), request.getParameter("email"));
    }
}
