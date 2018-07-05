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
	// make sure the connection is a single object
	private static Connection conn = null;
	/* Please use the following code to get the connection string */
	/*
	 * If you need to modify the parameters you may go to:
	 * /library/src/main/java/com/jac/web/dao/dbconfig.properties If the file is not
	 * there you may create it separately by adding a file to the project at the
	 * specified location This is file is in git ignore so we don't put publicly our
	 * gearhost connection strings on github the keys that should be there are: #DB
	 * Properties db.driver="driverclassname"
	 * db.url=jdbc:mysql://localhost:3306/YOURDBNAME db.username=USERNAME
	 * db.password=PASSWORD Please adjust the values when you will create the
	 * database.
	 */

	private static Connection getConnection() {
		// make sure the connection is a single object
		if (conn == null) {
			ResourceBundle reader = null;
			try {
//				reader = ResourceBundle.getBundle("dbconfig.properties");
//				Class.forName(reader.getString("db.driver"));
//				conn = DriverManager.getConnection(reader.getString("db.url"), reader.getString("db.username"),
//						reader.getString("db.password"));
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://den1.mysql2.gear.host/ejblibrary", "ejblibrary",
						"Iz8voBg0xU~-");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

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
		Connection conn = getConnection();
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
