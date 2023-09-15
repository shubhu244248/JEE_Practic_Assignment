package com.OracleDBOperation.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertPreparedStatement {

	public static void main(String[] args) {

		Scanner sc = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sc = new Scanner(System.in);
			int numStd = 0;
			if (sc != null) {
				System.out.println("Enter number of employee data you are adding :");
				numStd = sc.nextInt();
			} // sc end

			// loading and register db driver
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

			if (conn != null) {
				String query = null;
				// SQL query
				query = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
				// prepare and execute query by using PreparedStatment
				ps = conn.prepareStatement(query);

				if (ps != null && sc != null) {
					for (int i = 1; i <= numStd; ++i) {
						// read each student input values
						System.out.println("ENTER " + i + " EMPLOYEE DETAILS");
						System.out.print("Enter empno: ");
						int empNo = sc.nextInt();
						// Consume the newline character left in the buffer
						System.out.print("Enter ename: ");
						String empName = sc.next();
						System.out.print("Enter job: ");
						String empJob = sc.next();
						System.out.print("Enter sal: ");
						double empSal = sc.nextDouble();
						// set each EMPLOYEE details as pre-compiled SQL query params
						ps.setInt(1, empNo);
						ps.setString(2, empName);
						ps.setString(3, empJob);
						ps.setDouble(4, empSal);
						// execute pre-compiled SQL query each time
						int result = ps.executeUpdate();
						// process execution result of pre-compiled-SQL query on row affected 
						if (result == 0)
							System.out.println(i + " EMPLOYEE DETAILS NOT INSERTED");
						else
							System.out.println(i + " EMPLOYEE DETAILS ARE INSERTED");
					} // for
				} // end ps and sc
			} // conn end

		} catch (SQLException se) {
			se.printStackTrace();

			// also you can implement SQL exception by user
		} catch (Exception e) {
			e.getStackTrace();
		} finally {

			// Closing all SQL connections obj with handling exceptions
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {

				se.getStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
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
