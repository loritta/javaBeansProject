package com.jac.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.BookDAO;
import com.jac.web.dao.UserDAO;

/**
 * Servlet implementation class DisableUserController
 */
public class DisableUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisableUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt( request.getParameter("ID"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		UserDAO userDb = new UserDAO();
		if(userDb.disableUserById(id)) {			
			out.print("You have already Disabled this user!");
		}else {
			out.print("Failure");
			//response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
		}
	}

}
