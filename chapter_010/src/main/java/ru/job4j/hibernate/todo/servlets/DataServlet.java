package ru.job4j.hibernate.todo.servlets;


import ru.job4j.hibernate.todo.mapper.ModelConverter;
import ru.job4j.hibernate.todo.validation.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getValidateService();

    /**
     * DataServlete return all data in db when user visit index.html
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        try {
            ModelConverter.convertModelToJson(resp, validateService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
