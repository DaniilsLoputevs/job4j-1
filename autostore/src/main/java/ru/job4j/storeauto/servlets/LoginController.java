package ru.job4j.storeauto.servlets;

import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.validate.ValidateAccount;
import ru.job4j.storeauto.validate.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class LoginController extends HttpServlet {
    private Validation<Account> validateAccount = ValidateAccount.getValidate();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");
        Account checked = validateAccount.find(new Account(login, password));
        if (Objects.nonNull(checked)) {
            return;
        }


    }
}

