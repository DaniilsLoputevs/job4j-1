package ru.job4j.servletapi.crud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateServlet extends HttpServlet {
    private Validate validate = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = ModelConstruct.model(req);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html>\n"
                +
                "<html lang='en'>"
                +
                "<head>"
                +
                "    <meta charset='UTF-8'>"
                +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                +
                "    <meta http-equiv='X-UA-Compatible' content='ie=edge'>\n"
                +
                "    <title>Document</title>"
                +
                "</head>"
                +
                "<body>");
        stringBuilder.append(" <form action='' method='post'>"
                +
                "            <input type='text'placeholder='id'name='id'value=" + model.getId()
                + ">"
                +
                "            <input type='text'placeholder='name'name='name'>"
                +
                "            <input type='text'placeholder='login'name='login'>"
                +
                "            <input type='text'placeholder='email'name='email'>"
                +
                "            <input type='submit'name='add'value='add'>"
                +
                "            <input type='hidden' name='action' value='edit'>"
                +
                "       </form>");

        writer.append(stringBuilder.toString());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate.update(ModelConstruct.model(req));


    }
}
