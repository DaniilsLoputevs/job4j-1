package ru.job4j.servletapi.crud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UsersCreateServ extends HttpServlet {
    private final Validate validate = ValidateService.getInstance();
    private final DispatchAction dispatchAction = new DispatchAction();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>"
                +
                "<html lang=\"en\">"
                +
                "<head>"
                +
                "    <meta charset=\"UTF-8\">"
                +
                "    <title>Сreate user</title>"
                +
                "</head>"
                +
                "      <form action=" + req.getContextPath() + "method=\"post\">\n"
                +
                "            <div>\n"
                +
                "                    <input type=\"text\"placeholder=\" id\"name=\"id\">\n"
                +
                "                </div>\n"
                +
                "                <div> \n"
                +
                "                    <input type=\"text\"placeholder =\" username\"name =\"name=\">\n"
                +
                "                </div>\n"
                +
                "                  <div>\n"
                +
                "                     <input type=\"text\" placeholder=\" email\"name=\"email\">\n"
                +
                "                  </div>\n"
                +
                "                 <div>\n"
                +
                "                    <input type=\"text\" placeholder=\" login\"name=\"login\">\n"
                +
                "                 </div>\n"
                +
                "                 <input type=\"submit\">\n"
                +
                "\n"
                +
                "       </form>"
                +
                "<body>");
        sb.append("</body>").append("</html>");
        pr.append(sb.toString());
        pr.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = "add";
        System.out.println(action);
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        Model tmp = new Model(id, name, login, email);
        dispatchAction.getMap().get(action).apply(tmp);
    }
}
