package ru.job4j.hibernate.todo.servlets;

import ru.job4j.hibernate.todo.model.Item;
import ru.job4j.hibernate.todo.validation.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServletController extends HttpServlet {
    private final ValidateService validateService = ValidateService.getValidateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = null;

    }

}
