package ru.job4j.storeauto.servlets;

import ru.job4j.storeauto.mapper.DataMapper;
import ru.job4j.storeauto.models.Advert;
import ru.job4j.storeauto.validate.ValidateAdvert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class DataServletController extends HttpServlet {
    private ValidateAdvert validateAdvert = ValidateAdvert.getValidate();
    private final ConcurrentHashMap<String, Supplier<List<Advert>>> actions = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("action");
        if (Objects.isNull(s)) {
            resp.setContentType("text/json");
            DataMapper.convertModelToJson(resp, validateAdvert.findAll());
        } else if (s.equals("findBy")) {
            resp.setContentType("text/json");
            List<Advert> adverts = validateAdvert.findByCarModel(req.getParameter("car_title"));
            DataMapper.convertModelToJson(resp, adverts);
        } else {
            resp.setContentType("text/json");
            List<Advert> adverts = actions.get(s).get();
            DataMapper.convertModelToJson(resp, adverts);
        }

    }


    @Override
    public void init() throws ServletException {
        this.load();
        super.init();
    }

    private void load() {
        actions.put("all_photo", validateAdvert::findByPhoto);
        actions.put("all", validateAdvert::findAll);
        actions.put("today", validateAdvert::findAllToday);
    }
}
