package com.jac.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.UserDAO;

/**
 * Servlet implementation class EnableUserController
 */
public class EnableUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnableUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html>\r\n" + 
				"<head>\r\n" + 
				"<title>Servlet.jsp</title>\r\n" + 
				"<body>\r\n" + 
				"	<h2>This is EnableUser Get Method!</h2>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt( request.getParameter("ID"));
		UserDAO userDb = new UserDAO();
		if(userDb.enableUserById(id)) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("You have already actived this user!");
		}else {
			response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
		}
	}

}
