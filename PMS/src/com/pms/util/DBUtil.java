package com.pms.util;

import java.sql.*;

public class DBUtil {
	
	public static Connection getDBConnection() {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}