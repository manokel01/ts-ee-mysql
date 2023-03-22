package com.manokel.dev.tinysensor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manokel.dev.tinysensor.dao.IUserDAO;
import com.manokel.dev.tinysensor.dao.UserDAOImpl;
import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.dto.UserDTO;
import com.manokel.dev.tinysensor.service.IUserService;
import com.manokel.dev.tinysensor.service.UserServiceImpl;
import com.manokel.dev.tinysensor.service.exceptions.UserNotFoundException;


@WebServlet("/tinysensor/delete")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserDAO userDAO = new UserDAOImpl();
	IUserService userServ = new UserServiceImpl(userDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id").trim());	
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setFirstname(firstname);
		userDTO.setLastname(lastname);
		try {
			userServ.deleteUser(id);
			request.setAttribute("user", userDTO);
			request.getRequestDispatcher("/tinysensor/static/templates/userdeleted.jsp")
					.forward(request, response);
		} catch (UserNotFoundException | DAOException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/tinysensor/static/templates/users.jsp")
					.forward(request, response);
		}
	}
}

