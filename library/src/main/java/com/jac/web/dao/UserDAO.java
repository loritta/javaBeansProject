package com.jac.web.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.jac.web.controller.Globals;
import java.sql.SQLException;
import com.jac.web.model.User;

public class UserDAO {

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
}
