package com.OracleDBOperatios.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCCodingStandard {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			sc = new Scanner(System.in);
			String db = null;
			if (sc != null) {
				System.out.println("Enter Database name for select operation : ");
				db = sc.nextLine();
			} // end sc if

			// if need to prepare SQL query for that I need to prepare the values
			// uname = "'" + uname + "'";

			// load and register JDBC Driver Oracle or MySQL
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

			if (conn != null) {
				// prepare SQL Statement and SQL query
				st = conn.createStatement();

				// SQL query in java
				String query = "select * from " + db;
				// Display quey
				System.out.println(query);

				if (st != null) {
					rs = st.executeQuery(query); // Storing data in ResultSet
					if (rs != null) {
						rs.next();
						while (rs.next()) {
							System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
						} // end rs at ART
					} // end rs if
				} // end st if
			}

		} catch (SQLException se) {
			se.printStackTrace();

			// also you can implement SQL exception by user
		} catch (Exception e) {
			e.getStackTrace();
		} finally {

			// Closing all SQL connections objs with handling exceptions
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
