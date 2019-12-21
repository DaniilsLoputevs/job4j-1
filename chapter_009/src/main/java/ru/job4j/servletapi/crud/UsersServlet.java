package ru.job4j.servletapi.crud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class UsersServlet extends HttpServlet {
    private final Validate validate = ValidateService.getInstance();
    private final DispatchAction dispatchAction = new DispatchAction();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("users", validate.findAll());
            req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        dispatchAction.getMap().get(action).apply(Extract.extracting(req));
        doGet(req, resp);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));

    }

}
