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
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>"
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
                "<body>");
        for (Model var : validate.findAll()) {
            sb.append("<td><tr>" + var.toString() + "</tr></td>").append("<form action=").append(req.getContextPath())
                    .append("/edit method='get'>")
                    .append("<button type='submit'>Edit</button>")
                    .append("<input type='hidden'name='id' value=" + var.getId() + ">")
                    .append("</form>")
                    .append("<form action='' method='post'>")
                    .append("<button type='submit'>Delete</button>")
                    .append("<input type='hidden'name='action'value='delete'>")
                    .append("<input type='hidden'name='id' value=" + var.getId() + ">")
                    .append("</form>");
        }
        sb.append("</body>");
        sb.append("</html>");
        pr.append(sb.toString());
        pr.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        dispatchAction.getMap().get(action).apply(ModelConstruct.model(req));
    }

}
