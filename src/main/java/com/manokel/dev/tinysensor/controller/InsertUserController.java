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
import com.manokel.dev.tinysensor.validation.Validator;


@WebServlet("/tinysensor/insert")
public class InsertUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final IUserDAO userDAO = new UserDAOImpl();
	private final IUserService userServ = new UserServiceImpl(userDAO);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("error", "");
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		String email = request.getParameter("email").trim();
		String address = request.getParameter("address").trim();
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstname(firstname);
		userDTO.setLastname(lastname);
		userDTO.setEmail(email);
		userDTO.setAddress(address);
		request.setAttribute("insertedUser", userDTO);
		try {
			String error = Validator.validate(userDTO);
			if (!error.equals("")) {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/tinysensor/static/templates/usersmenu.jsp")
						.forward(request, response);
			}
			userServ.insertUser(userDTO);
			request.getRequestDispatcher("/tinysensor/static/templates/userinserted.jsp")
					.forward(request, response);
		} catch (DAOException e) {
			//e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/tinysensor/static/templates/usersmenu.jsp")
					.forward(request, response);
		}
	}
}

