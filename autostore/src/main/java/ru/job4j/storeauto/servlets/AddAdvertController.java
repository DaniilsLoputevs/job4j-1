package ru.job4j.storeauto.servlets;

import ru.job4j.storeauto.mapper.DataMapper;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.models.Advert;
import ru.job4j.storeauto.models.Photo;
import ru.job4j.storeauto.validate.ValidateAccount;
import ru.job4j.storeauto.validate.ValidateAdvert;
import ru.job4j.storeauto.validate.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;


@MultipartConfig(maxFileSize = 8000000)
public class AddAdvertController extends HttpServlet {
    private Validation<Advert> validate = ValidateAdvert.getValidate();
    private Validation<Account> validateAccount = ValidateAccount.getValidate();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");
        Account creator = validateAccount.find(new Account(login, password));
        Advert inserted = DataMapper.convertReqDataToModel(req);
        Photo photo = DataMapper.fileOfPartRequest(req);
        inserted.setAccount(creator);
        inserted.setPhoto(photo);
        validate.add(inserted);
    }
}
