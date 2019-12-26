package ru.job4j.servletapi.crud.filters;

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
        if (!role.equals("ADMIN")) {
            ((HttpServletResponse) resp).sendRedirect(String.format("%s/signin", ((HttpServletRequest) req).getContextPath()));
            session.invalidate();
        }
    }

    @Override
    public void destroy() {

    }
}
