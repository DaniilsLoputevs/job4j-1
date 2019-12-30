package ru.job4j.servletapi.crud.servlets;

import ru.job4j.servletapi.crud.Extract;
import ru.job4j.servletapi.crud.Validate;
import ru.job4j.servletapi.crud.ValidateService;
import ru.job4j.servletapi.crud.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    private Validate validate = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = Extract.extractingUser(req);
        resp.setContentType("text/html");
    }

    /**
     * Extracting User on storage and delete
     * @param req request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate.delete(Extract.extractingUser(req));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
