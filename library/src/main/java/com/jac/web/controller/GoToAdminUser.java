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

/**
 * Servlet implementation class GoToAdminUser
 */
public class GoToAdminUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToAdminUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDb=new UserDAO();
		ArrayList<User> usersUnActiveList = userDb.getAllUnActiveUser();
		ArrayList<User> usersActiveList = userDb.getAllActiveUser();
		request.setAttribute("usersUnActiveList", usersUnActiveList);
		request.setAttribute("usersActiveList", usersActiveList);
		
		RequestDispatcher rd = request.getRequestDispatcher("indexAdminUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
