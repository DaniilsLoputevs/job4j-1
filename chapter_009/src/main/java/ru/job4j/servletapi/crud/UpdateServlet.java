package ru.job4j.servletapi.crud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = new Model(req.getParameter("id"), req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
        System.out.println(model);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html>\n"
                +
                "<html lang=\"en\">\n"
                +
                "<head>\n"
                +
                "    <meta charset=\"UTF-8\">\n"
                +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
                +
                "    <title>Document</title>\n"
                +
                "</head>\n"
                +
                "<body>");
        stringBuilder.append(" <form action=\"list\" method=\"post\">\n"
                +
                "            <input type=\"text\"placeholder=\"id\"name=\"id\"value=" + model.getId()
                + ">"
                +
                "            <input type=\"text\"placeholder=\"name\"name=\"name\">\n"
                +
                "            <input type=\"text\"placeholder=\"login\"name=\"login\">\n"
                +
                "            <input type=\"text\"placeholder=\"email\"name=\"email\">\n"
                +
                "            <input type=\"submit\"name=\"add\"value=\"add\">\n"
                +
                "            <input type=\"hidden\" name=\"action\" value=\"edit\">\n"
                +
                "       </form>");

        writer.append(stringBuilder.toString());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
