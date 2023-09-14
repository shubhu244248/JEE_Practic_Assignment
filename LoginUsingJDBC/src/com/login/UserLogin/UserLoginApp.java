package com.login.UserLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLoginApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			sc = new Scanner(System.in);
			String uname = null;
			String upass = null;
			if (sc != null) {
				System.out.println("Enter Username : ");
				uname = sc.nextLine();
				System.out.println("Enter Password : ");
				upass = sc.nextLine();
			} // end sc if

			// prepare SQL query for that I need to prepare the values
			uname = "'" + uname + "'";
			upass = "'" + upass + "'";

			// load and register JDBC Driver Oracle or MySQL
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

			if (conn != null) {
				// prepare SQL Statement and SQL query
				st = conn.createStatement();

				// SQL query in java
				String query = "select count(*) from LoginUser where uname =" + uname + " and upass =" + upass;
				// Display quey
				System.out.println(query);

				if (st != null) {
					rs = st.executeQuery(query); // Storing data in ResultSet
					if (rs != null) {
						rs.next();
						int count = rs.getInt(1); // SQL Injection problem happens so need to handle it in future
						if (count == 0) {
							System.out.println("Invalid Credentials");
						} else {
							System.out.println("Valid Credentials");
						}
					} // end rs if
				} // end st if
			} // end conn if

		} catch (SQLException se) { // end try
			se.printStackTrace();

			// also you can implement SQL exception by user
		} catch (Exception e) {
			e.getStackTrace();
		} finally {

			// Closing all SQL connections with handling exceptions
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {

				se.getStackTrace();
			}

			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException se) {
				se.getStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.getStackTrace();
			}

			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		} // end finally
	}
}
