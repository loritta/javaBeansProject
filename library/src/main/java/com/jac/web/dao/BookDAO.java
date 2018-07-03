package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class BookDAO {

	/* Please use the following code to get the connection string */
	/*
	 * If you need to modify the parameters you may go to:
	 * /library/src/main/java/com/jac/web/dao/dbconfig.properties If the file is not
	 * there you may create it separately by adding a file to the project at the
	 * specified location This is file is in git ignore so we don't put publicly our
	 * gearhost connection strings on github the keys that should be there are: 
	 * #DB
	 * Properties 
	 * db.driver="driverclassname"
	 * db.url=jdbc:mysql://localhost:3306/YOURDBNAME 
	 * db.username=USERNAME
	 * db.password=PASSWORD
	 * Please adjust the values when you will create the database.
	 */
	public Connection getConnection() {
		Connection conn = null;
		ResourceBundle reader = null;
		try {
			reader = ResourceBundle.getBundle("dbconfig.properties");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(reader.getString("db.url"), reader.getString("db.username"),
					reader.getString("db.password"));

		} catch (Exception e) {
		}
		return conn;
	}
}
