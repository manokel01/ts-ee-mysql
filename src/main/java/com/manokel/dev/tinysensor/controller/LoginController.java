package com.manokel.dev.tinysensor.controller;

import com.manokel.dev.tinysensor.authentication.AuthenticationProvider;
import com.manokel.dev.tinysensor.dto.DBUserDTO;
import com.manokel.dev.tinysensor.model.DBUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/tinysensor/static/templates/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        DBUserDTO userDTO = new DBUserDTO();
        userDTO.setUsername(email);
        userDTO.setPassword(password);

        DBUser user = AuthenticationProvider.authenticate(userDTO);
        if (user == null) response.sendRedirect(request.getContextPath() + "/login");

        HttpSession session = request.getSession(true);
        assert user != null;
        // "username" is used in login page "Welcome" message
        session.setAttribute("username", user.getUsername());

        session.setMaxInactiveInterval(60 * 15); // 15min

        // acknowledge authentication by sending Cookie
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(session.getMaxInactiveInterval());
        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath() + "/tinysensor/menu");
    }
}
