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
                "<body>"
                +
                "<form method='post' action='create'>"
                +
                "<input type='text'placeholder='id'name='id'>"
                +
                "<input type='text'placeholder='name'name='name'>"
                +
                "<input type='text'placeholder='login'name='login'>"
                +
                "<input type='text'placeholder='email'name='email'>"
                +
                "<input type='submit'name='sub'value='enter'>"
                +
                "<input type ='hidden'name='action'value='add'>"
                +
                "</form>"
        );
        sb.append("</body>").append("</html>");
        pr.append(sb.toString());
        pr.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        User tmp = new User(id, name, login, email);
        dispatchAction.getMap().get(action).apply(tmp);
    }
}
