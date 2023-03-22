package com.manokel.dev.tinysensor.controller;

import com.manokel.dev.tinysensor.dao.IUserDAO;
import com.manokel.dev.tinysensor.dao.UserDAOImpl;
import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.dto.UserDTO;
import com.manokel.dev.tinysensor.model.User;
import com.manokel.dev.tinysensor.service.IUserService;
import com.manokel.dev.tinysensor.service.UserServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SearchUsersController", value = "/tinysensor/search")
public class SearchUsersController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserDAO userDAO = new UserDAOImpl();
    IUserService userService = new UserServiceImpl(userDAO);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/tinysensor/static/templates/usersmenu.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String lastname = request.getParameter("lastname").trim();
        UserDTO userDTO = new UserDTO();
        userDTO.setLastname(lastname);
        String message = "";
        try {
            List<User> users = userService.getUsersByLastname(userDTO.getLastname());
            if (users.size() == 0) {
                request.setAttribute("usersNotFound", true);
                request.getRequestDispatcher("/tinysensor/static/templates/usersmenu.jsp")
                        .forward(request, response);
            }
            request.setAttribute("users", users);
            request.getRequestDispatcher("/tinysensor/static/templates/users.jsp").forward(request, response);
        } catch (DAOException e) {
            message = e.getMessage();
            request.setAttribute("isError", true);
            request.setAttribute("errorMessage", message);
            request.getRequestDispatcher("/tinysensor/usersmenu.jsp").forward(request, response);
        }
    }
}
