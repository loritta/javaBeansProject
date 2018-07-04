package com.jac.web.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.ResourceBundle;

import com.jac.web.model.User;

public class UserDAO {

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
			Properties prop=new Properties();
			InputStream in = getClass().getResourceAsStream("dbconfig.properties");
			prop.load(in);
	        in.close();
			
	        String drivers = prop.getProperty("jdbc.drivers");
            String connectionURL = prop.getProperty("jdbc.url");
            String username = prop.getProperty("jdbc.username");
            String password = prop.getProperty("jdbc.password");
            Class.forName(drivers);
            con=DriverManager.getConnection(connectionURL,username,password);
            System.out.println("Connection Successful");
	        
			reader = ResourceBundle.getBundle("dbconfig.properties");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(reader.getString("db.url"), reader.getString("db.username"),
					reader.getString("db.password"));

		} catch (Exception e) {
		}
		return conn;
	}

	public User getUser(String username) {
		User u = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = getConnection();
					//DriverManager.getConnection("jdbc:mysql://den1.mysql2.gear.host/ejblibrary", "ejblibrary",
					//"Iz8voBg0xU~-");
			String query = "select * from users where username=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				u = new User();
				String usernameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				int roleId = rs.getInt("roleID");
				u.setUsername(usernameFromDB);
				u.setPassword(passwordFromDB);
				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setRoleId(roleId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
