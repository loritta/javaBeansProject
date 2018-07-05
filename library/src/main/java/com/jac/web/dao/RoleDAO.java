package com.jac.web.dao;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.jac.web.model.UserRoles;

public class RoleDAO {


	public List<UserRoles> list() throws SQLException{
		
		List<UserRoles> listRoles = new ArrayList<UserRoles>();
        
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql2.gear.host/ejblibrary", "ejblibrary", "Iz8voBg0xU~-");

            String sql = "SELECT * FROM roles ORDER BY name";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                UserRoles roles = new UserRoles(id, name);
                     
                listRoles.add(roles);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listRoles;
		
	}
	

}