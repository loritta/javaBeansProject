package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jac.web.controller.Globals;
import com.jac.web.model.Book;

public class BookDAO {

	public static Boolean deleteBookById(int id) {
		Connection conn = Globals.db.getConnection();
		try {
			String SQL = "DELETE FROM books WHERE id = ? ";
			PreparedStatement pstmt = null;

			// get a connection and then in your try catch for executing your delete...

			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<Book> getAllBook() {
		Connection conn = Globals.db.getConnection();
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			String query = "SELECT * FROM ejblibrary.books order by id desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int publishYear = rs.getInt("publishYear");
				String picLink = rs.getString("picLink");
				bookList.add(new Book(id, title, author, publishYear, picLink));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
}
