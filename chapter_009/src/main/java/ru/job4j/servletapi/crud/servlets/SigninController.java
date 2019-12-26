package ru.job4j.servletapi.crud.servlets;

import ru.job4j.servletapi.crud.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SigninController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/Authview.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        session.setAttribute("login", login);
        String password = req.getParameter("password");
        session.setAttribute("password", password);
        String role = (DbStore.getinstance().getRole(login));
        session.setAttribute("role", role);
        if (role.equals("ADMIN")) {
            resp.sendRedirect(String.format("%s/admin", req.getContextPath()));
        } else if (role.equals("USER")) {
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "Invalid login or password");
            doGet(req, resp);
        }
    }
}
