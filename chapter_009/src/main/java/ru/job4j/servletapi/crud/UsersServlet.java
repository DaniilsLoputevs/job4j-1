package ru.job4j.servletapi.crud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UsersServlet extends HttpServlet {
    private final Validate validate = ValidateService.getInstance();
    private final DispatchAction dispatchAction = new DispatchAction();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        StringBuilder sb = new StringBuilder("<table>");
        for (Model var : validate.findAll()) {
            sb.append("<td><tr>" + var.toString() + "</tr></td>");
        }
        sb.append("</table>");
        pr.append("<!DOCTYPE html>"
                +
                "<html lang=\"en\">"
                +
                "<head>"
                +
                "    <meta charset=\"UTF-8\">"
                +
                "    <title>Title</title>"
                +
                "</head>"
                +
                "<body>"
                +
                "<form action='"
                + req.getContextPath()
                + "'/list' method='post'>"
                +
                "Name: <input type= text 'name='login'/>"
                +
                "<input type='submit'>"
                +
                "</body>"
                +
                "<br/"
                +
                sb.toString()
                +
                "</html>");
        pr.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
