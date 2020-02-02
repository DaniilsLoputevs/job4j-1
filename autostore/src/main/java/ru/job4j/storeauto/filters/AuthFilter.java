package ru.job4j.storeauto.filters;

import ru.job4j.storeauto.mapper.DataMapper;
import ru.job4j.storeauto.models.Account;

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
     * Checking auth and redirect resp
     *
     * @param req         req
     * @param response    resp
     * @param filterChain filerchain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        Account account = DataMapper.convertJsonToModel(request, Account.class);
        if (request.getRequestURI().contains("/login")) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("login", account.getEmail());
            session.setAttribute("password", account.getPassword());
            if (session.getAttribute("login") == null) {
                ((HttpServletResponse) response).sendRedirect(String.format("%s/auth", ((HttpServletRequest) req).getContextPath()));
                return;
            }
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
