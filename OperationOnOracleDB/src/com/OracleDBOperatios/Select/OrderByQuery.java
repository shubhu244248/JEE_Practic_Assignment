package com.OracleDBOperatios.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OrderByQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String pass = "admin";
		
		try {
			Connection conn = DriverManager.getConnection(url, user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}