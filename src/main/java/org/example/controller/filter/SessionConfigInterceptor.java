package org.example.controller.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionConfigInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        boolean aNew = session.isNew();
        if (aNew && !request.getServletPath().equals("/")&&!request.getServletPath().equals("/login")) {
            response.sendRedirect("/login");
        }
        return true;
    }
}
