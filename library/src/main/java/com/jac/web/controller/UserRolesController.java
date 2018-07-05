package com.jac.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.RoleDAO;
import com.jac.web.model.UserRoles;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UserRolesController
 */
public class UserRolesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleDAO dao = new RoleDAO();
		 
        try {
 
            List<UserRoles> listRoles = dao.list();
            request.setAttribute("listRoles", listRoles);
 
            RequestDispatcher dispatcher = request.getRequestDispatcher("addEditUser.jsp");
            dispatcher.forward(request, response);
 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
	}


