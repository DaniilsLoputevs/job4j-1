package ru.job4j.storeauto.servlets;

import ru.job4j.storeauto.mapper.DataMapper;
import ru.job4j.storeauto.models.Advert;
import ru.job4j.storeauto.validate.ValidateAdvert;
import ru.job4j.storeauto.validate.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataServletController extends HttpServlet {
    private Validation<Advert> validateAdvert = ValidateAdvert.getValidate();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        DataMapper.convertModelToJson(resp, validateAdvert.findAll());
    }
}
