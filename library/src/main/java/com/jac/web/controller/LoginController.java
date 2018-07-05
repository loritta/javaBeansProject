package com.jac.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.BookDAO;
import com.jac.web.dao.UserDAO;
import com.jac.web.model.Book;
import com.jac.web.model.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserDAO user = new UserDAO();
			
			User u = user.getUser(username);
			
			String loginErrorMessage = "Error: ";
			boolean loginError = false;
			// Switch login error
			if (u == null) {
				loginErrorMessage += "Username " + username + " was not found";
				loginError = true;
			} else if (!u.isActive()) {
				loginErrorMessage += "Account " + username + " is not active";
				loginError = true;
			} else if (!password.equals(u.getPassword())) {
				loginErrorMessage += "Entered password for account " + username + " is incorrect";
				loginError = true;
			}
			
			if (loginError) {
				request.setAttribute("error", loginErrorMessage);
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else { //Login successful
				Globals.IsAuthorized = true;
				Globals.FullName = u.getFirstName() + " " + u.getLastName();
				request.setAttribute("user", u);
				if (u.getRoleId() == 2) {
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				} else if (u.getRoleId() == 1) {
					Globals.IsAdmin = true;
					response.sendRedirect(Globals.RootPath+"/GoToAdmin");
//					ArrayList<Book> booksList = BookDAO.getAllBook();
//					request.setAttribute("booksList", booksList);
//					RequestDispatcher rd = request.getRequestDispatcher("indexAdmin.jsp");
//					rd.forward(request, response);
				}
			}
			
	}

}
