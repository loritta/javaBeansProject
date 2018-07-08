package com.jac.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.UserDAO;
import com.jac.web.model.User;

/**
 * Servlet implementation class EditUserController
 */
public class EditUserController extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			user.setUsername(request.getParameter("username"));
			
			String pass = request.getParameter("password");
			String passRe = request.getParameter("passwordRe");
			if(pass.equals(passRe)) {
				user.setPassword(request.getParameter("password"));
			}else {
				request.setAttribute("error", 
						"Password is not match.");
				RequestDispatcher rd = request.getRequestDispatcher("addEditUser.jsp");
				rd.forward(request, response);
			}			
			int id = Integer.parseInt(request.getParameter("Id")); 
			int roleId = Integer.parseInt(request.getParameter("role"));  
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			user.setPhone(request.getParameter("phone"));
			user.setAddress(request.getParameter("address"));
			user.setCity(request.getParameter("city"));
			user.setProvince(request.getParameter("province"));
			user.setZip(request.getParameter("zipcode"));
			user.setRoleId(roleId);
			user.setID(id);
			
			UserDAO userDao = new UserDAO();
			if(!userDao.updateUser(user)) {
				request.setAttribute("error", 
						"Update user failure!");
				RequestDispatcher rd = request.getRequestDispatcher("addEditUser.jsp");
				rd.forward(request, response);
			}
			response.sendRedirect("GoToAdminUser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
