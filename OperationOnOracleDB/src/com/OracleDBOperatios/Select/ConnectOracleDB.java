package com.OracleDBOperatios.Select;

import java.sql.*;

public class ConnectOracleDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver"); // loading Oracle Db driver 
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin"); // Connecting via DriverManager Class Or services to the database 
		
		Statement st = conn.createStatement(); // Create Statement interface obj for the execution
		
		if(st==null) {
			System.out.println("Something wrong");
		} else {
			System.out.println("Connection Done....");
		}
		conn.close();
	}

}
