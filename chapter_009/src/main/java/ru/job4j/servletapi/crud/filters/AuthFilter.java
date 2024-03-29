package ru.job4j.servletapi.crud.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Checking role and redirect resp
     * @param req req
     * @param response resp
     * @param filterChain filerchain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getRequestURI().contains("/signin")) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("login") == null) {
                ((HttpServletResponse) response).sendRedirect(String.format("%s/signin", ((HttpServletRequest) req).getContextPath()));
                return;
            }
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
