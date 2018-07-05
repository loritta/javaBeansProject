package com.jac.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.UserDAO;
import com.jac.web.model.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserDAO user = new UserDAO();
			
			User u = user.getUser(username);
			if(!u.isActive()) {
				request.setAttribute("error", 
						"Error: Your account is not active");
				System.out.println("Error: Your account is not active");
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
			
			if(password.equals(u.getPassword())) {
				
				Globals.IsAuthorized=true;
				Globals.FullName = u.getFirstName()+" "+ u.getLastName();
				request.setAttribute("user", u);
				if(u.getRoleId()==2) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				}
				else if (u.getRoleId()==1) {
					Globals.IsAdmin=true;
					RequestDispatcher rd = request.getRequestDispatcher("indexAdmin.jsp");
					rd.forward(request, response);
				}
				
			}else {
				Globals.IsAuthorized=false;
				request.setAttribute("username", null);
				request.setAttribute("error", 
						"Wrong username or password.");
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
			
			
	}

}
