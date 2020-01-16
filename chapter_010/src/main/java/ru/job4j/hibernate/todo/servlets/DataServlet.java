package ru.job4j.hibernate.todo.servlets;


import ru.job4j.hibernate.todo.mapper.ModelConverter;
import ru.job4j.hibernate.todo.model.Item;
import ru.job4j.hibernate.todo.validation.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class DataServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getValidateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validateService.add(new Item("test", "test", Timestamp.valueOf(LocalDateTime.now())));
        resp.setContentType("text/json");
        resp.getWriter().write(ModelConverter.convertModelToJson(validateService.findAll()));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
