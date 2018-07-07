package com.jac.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.BookDAO;
import com.jac.web.model.Book;

/**
 * Servlet implementation class GoToUser
 */
public class GoToUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Book> booksList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		booksList = BookDAO.getAllBook();
		if(booksList==null)booksList = new ArrayList<Book>();
		request.setAttribute("booksList", booksList);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString = request.getParameter("search");
		ArrayList<Book> booksListSort = new ArrayList<Book>();
		for(Book book : booksList) {
			if(book.getTitle().toLowerCase().contains(searchString.toLowerCase())) booksListSort.add(book);
		}
		request.setAttribute("booksList", booksListSort);
		request.setAttribute("searchString", searchString);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
