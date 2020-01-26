package ru.job4j.storeauto.servlets;

import ru.job4j.storeauto.mapper.DataMapper;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.validate.ValidateAccount;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAccountController extends HttpServlet {
    private ValidateAccount validateAccount = ValidateAccount.getValidate();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = DataMapper.convertJsonToModel(req, Account.class);
        validateAccount.add(account);
        req.setAttribute("id", account.getId());

    }
}
