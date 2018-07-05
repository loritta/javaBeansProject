package com.jac.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.jac.web.controller.Globals;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jac.web.model.Book;
import com.jac.web.model.User;

public class UserDAO {

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
//	public Connection getConnection() {		
//		
//		Connection conn = null;
//		ResourceBundle reader = null;		
//		try {
//			//reader = ResourceBundle.getBundle("dbconfig.properties");
//			//String  driver = reader.getString("db.driver");
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://den1.mysql2.gear.host/ejblibrary",
//					"ejblibrary",
//					"Iz8voBg0xU~-");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}

	public User getUser(String username) {
		User u = null;
		try {
			String query = "select * from users where username=?";

			PreparedStatement st = Globals.db.getConnection().prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				u = new User();
				String usernameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				boolean isActive = rs.getBoolean("isActive");
				int roleId = rs.getInt("roleID");
				u.setUsername(usernameFromDB);
				u.setPassword(passwordFromDB);
				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setRoleId(roleId);
				u.setActive(isActive);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public void addUser() throws ClassNotFoundException {
		User user = new User();
		try {
			String query = "INSERT INTO users (username, password, firstName, lastName, phone, address, city, province, zip, roleID) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = Globals.db.getConnection().prepareStatement(query);

			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3, user.getFirstName());
			st.setString(4, user.getLastName());
			st.setString(5, user.getPhone());
			st.setString(6, user.getAddress());
			st.setString(7, user.getCity());
			st.setString(8, user.getProvince());
			st.setString(9, user.getZip());
			st.setString(10, "2");
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addUser(User user) throws ClassNotFoundException {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = Globals.db.getConnection();
			String query = "INSERT INTO users (username, password, firstName, lastName, phone, address, city, province, zip, roleID) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3, user.getFirstName());
			st.setString(4, user.getLastName());
			st.setString(5, user.getPhone());
			st.setString(6, user.getAddress());
			st.setString(7, user.getCity());
			st.setString(8, user.getProvince());
			st.setString(9, user.getZip());
			st.setString(10, "2");
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Jie Add Below Function, Please don't remove
	public User getUserById(int id) {
		User u = null;
		try {
			String query = "select * from users where id=?";

			PreparedStatement st = Globals.db.getConnection().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				u = new User();
				String usernameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				boolean isActive = rs.getBoolean("isActive");
				int roleId = rs.getInt("roleID");
				u.setUsername(usernameFromDB);
				u.setPassword(passwordFromDB);
				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setRoleId(roleId);
				u.setActive(isActive);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public ArrayList<User> getAllUnActiveUser() {
		Connection conn = Globals.db.getConnection();
		ArrayList<User> userList = new ArrayList<User>();
		try {
			String query = "SELECT * FROM ejblibrary.users where isActive=0 order by id desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				User u = new User();
				int id = rs.getInt("id");
				String usernameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				Boolean isActive = rs.getBoolean("isActive");
				int roleId = rs.getInt("roleID");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String province = rs.getString("province");
				String zip = rs.getString("zip");
				u.setID(id);
				u.setUsername(usernameFromDB);
				u.setPassword(passwordFromDB);
				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setRoleId(roleId);
				u.setActive(isActive);
				u.setPhone(phone);
				u.setCity(city);
				u.setProvince(province);
				u.setZip(zip);
				userList.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public ArrayList<User> getAllActiveUser() {
		Connection conn = Globals.db.getConnection();
		ArrayList<User> userList = new ArrayList<User>();
		try {
			String query = "SELECT * FROM ejblibrary.users where isActive=1 order by id desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				User u = new User();
				int id = rs.getInt("id");
				String usernameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				Boolean isActive = rs.getBoolean("isActive");
				int roleId = rs.getInt("roleID");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String province = rs.getString("province");
				String zip = rs.getString("zip");
				u.setID(id);
				u.setUsername(usernameFromDB);
				u.setPassword(passwordFromDB);
				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setRoleId(roleId);
				u.setActive(isActive);
				u.setPhone(phone);
				u.setCity(city);
				u.setProvince(province);
				u.setZip(zip);
				userList.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public Boolean disableUserById(int id) {

		String query = "UPDATE ejblibrary.users SET isActive=0 WHERE id=?";
		Connection conn = Globals.db.getConnection();
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);			
			preparedStmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean enableUserById(int id) {

		String query = "UPDATE ejblibrary.users SET isActive=1 WHERE id=?";
		Connection conn = Globals.db.getConnection();
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);			
			preparedStmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
