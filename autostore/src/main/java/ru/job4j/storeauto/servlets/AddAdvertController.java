package ru.job4j.storeauto.servlets;

import ru.job4j.storeauto.mapper.DataMapper;
import ru.job4j.storeauto.models.Advert;
import ru.job4j.storeauto.validate.ValidateAdvert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAdvertController extends HttpServlet {
    private ValidateAdvert validate = ValidateAdvert.getValidate();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Advert advert = DataMapper.convertJsonToModel(req, Advert.class);
        validate.add(advert);

    }
}
