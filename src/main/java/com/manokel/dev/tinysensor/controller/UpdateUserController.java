package com.manokel.dev.tinysensor.controller;

import com.manokel.dev.tinysensor.dao.IUserDAO;
import com.manokel.dev.tinysensor.dao.UserDAOImpl;
import com.manokel.dev.tinysensor.dao.exceptions.DAOException;
import com.manokel.dev.tinysensor.dto.UserDTO;
import com.manokel.dev.tinysensor.service.IUserService;
import com.manokel.dev.tinysensor.service.UserServiceImpl;
import com.manokel.dev.tinysensor.service.exceptions.UserNotFoundException;
import com.manokel.dev.tinysensor.validation.Validator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/tinysensor/update")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final IUserDAO userDAO = new UserDAOImpl();
	private final IUserService userServ = new UserServiceImpl(userDAO);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/tinysensor/static/templates/userupdate.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		UserDTO newUserDTO = new UserDTO();
		newUserDTO.setId(id);
		newUserDTO.setFirstname(firstname);
		newUserDTO.setLastname(lastname);
		newUserDTO.setEmail(email);
		newUserDTO.setAddress(address);
		request.setAttribute("insertedUser", newUserDTO);
		
		try {
			String error = Validator.validate(newUserDTO);
			if (!error.equals("")) {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/tinysensor/static/templates/usersmenu.jsp")
						.forward(request, response);
			}
			userServ.updateUser(newUserDTO);
			request.setAttribute("user", newUserDTO);
			request.getRequestDispatcher("/tinysensor/static/templates/userupdated.jsp")
					.forward(request, response);
		} catch (UserNotFoundException | DAOException e) {
			String message = e.getMessage();
			request.setAttribute("isError", true);
			request.setAttribute("user", newUserDTO);
			request.getRequestDispatcher("/tinysensor/static/templates//userupdated.jsp")
					.forward(request, response);

		}
	}
}
