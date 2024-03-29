package ru.job4j.servletapi.crud.servlets;

import ru.job4j.servletapi.crud.DispatchAction;
import ru.job4j.servletapi.crud.Extract;
import ru.job4j.servletapi.crud.Validate;
import ru.job4j.servletapi.crud.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class UsersServlet extends HttpServlet {
    private final Validate validate = ValidateService.getInstance();
    private final DispatchAction dispatchAction = new DispatchAction();

    /**
     * return all Users in storage . using UsersView.jsp
     *
     * @param req  request by user
     * @param resp response by server
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", validate.findAll());
        req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);

    }

    /**
     * Get action when user send post method and execute work in dispatchAction
     *
     * @param req  request by
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        dispatchAction.getMap().get(action).apply(Extract.extractingUser(req));
        doGet(req, resp);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));

    }

}
