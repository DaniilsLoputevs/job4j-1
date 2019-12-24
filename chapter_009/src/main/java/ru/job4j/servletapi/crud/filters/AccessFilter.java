package ru.job4j.servletapi.crud.filters;

import ru.job4j.servletapi.crud.store.DbStore;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = ((HttpServletRequest) req).getSession();
        String role = (String) session.getAttribute("role");
        String login = (String) session.getAttribute("login");
        System.out.println(role);
        System.out.println(login);
        if (DbStore.getinstance().getroleid(login) == 1) {
            ((HttpServletResponse) resp).sendRedirect(String.format("%s/", ((HttpServletRequest) req).getContextPath()));
        }

    }

    @Override
    public void destroy() {

    }
}
