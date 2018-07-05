package com.jac.web.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
	public Connection getConnection() {
		
		Connection conn = null;
		try {
			Properties prop=new Properties();
			InputStream in = getClass().getResourceAsStream("dbconfig.properties");
			prop.load(in);
	        in.close();
			
	        String drivers = prop.getProperty("db.driver");
            String connectionURL = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            Class.forName(drivers);
            conn=DriverManager.getConnection(connectionURL,username,password);
            
		} catch (Exception e) {
		}
		return conn;
	}
	
}
