package com.OracleDBOperatios.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OrderByQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String pass = "admin";

		Scanner sc = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// get input column name from user
			sc = new Scanner(System.in);
			String column = null;
			if (sc != null) {
				System.out.println("We are performing this Order by using table column \n EMPNO,ENAME,JOB,SAL,DEPTNO");
				column = sc.nextLine();
			} // sc if end

			// connecting to database
			// register driver
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);

			if (conn != null) {
				st = conn.createStatement(); // create statment obj
				// SQL Query
				// SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP ORDER BY SAL;
				String query = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP ORDER BY " + column;
				System.out.println(query);
				// store data in result set
				if (st != null) {
					rs = st.executeQuery(query);

					while (rs.next()) {
						System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
								+ rs.getString(4) + " " + rs.getString(5));
					}

				} // st if end

			} // conn if end

		} catch (SQLException se) {
			se.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			// close objs
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
		}

	}

}