package ru.job4j.storeauto.servlets;

import ru.job4j.storeauto.mapper.DataMapper;
import ru.job4j.storeauto.models.Car;
import ru.job4j.storeauto.validate.ValidateCar;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCarController extends HttpServlet {
    private ValidateCar validateCar = ValidateCar.getValidate();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = DataMapper.convertJsonToModel(req, Car.class);
        validateCar.add(car);

    }
}
