package ru.job4j.storeauto.servlets;

import ru.job4j.storeauto.mapper.DataMapper;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.models.Advert;
import ru.job4j.storeauto.models.Car;
import ru.job4j.storeauto.validate.ValidateAccount;
import ru.job4j.storeauto.validate.ValidateAdvert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


public class AddAdvertController extends HttpServlet {
    private ValidateAdvert validate = ValidateAdvert.getValidate();
    private ValidateAccount validateAccount = ValidateAccount.getValidate();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");
        Account creator = validateAccount.find(new Account(login, password));
        Advert inserted = DataMapper.convertJsonToModel(req, Advert.class);
        inserted.setAccount(creator);
        validate.add(inserted);

    }
}
