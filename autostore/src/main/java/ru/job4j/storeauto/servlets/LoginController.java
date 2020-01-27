package ru.job4j.storeauto.servlets;

import ru.job4j.storeauto.mapper.DataMapper;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.validate.ValidateAccount;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private ValidateAccount validateAccount = ValidateAccount.getValidate();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = new Account();
        account = DataMapper.convertJsonToModel(req, Account.class);
        if (account.equals(validateAccount.find(account))) {
            resp.sendRedirect(String.format("%s/page/index.html", req.getContextPath()));
        }

    }
}
