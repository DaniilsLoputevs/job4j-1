package ru.job4j.hibernate.todo.servlets;

import ru.job4j.hibernate.todo.mapper.ModelConverter;
import ru.job4j.hibernate.todo.model.Item;
import ru.job4j.hibernate.todo.validation.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServletController extends HttpServlet {
    private final ValidateService validateService = ValidateService.getValidateService();

    /**
     * Adding new item and -> on validate service .
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item value = ModelConverter.convertJsontoModel(req);
       validateService.add(value);
    }

}
