package com.OracleDBOperatios.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertIntoTable {

	public static void main(String[] args) {

//		 insert into emp (empno,ename,job,sal) values (1001,'Shubham','Soft Engg',20000)

		Scanner sc = null;
		Connection conn = null;
		Statement st = null;
		try {
			sc = new Scanner(System.in);
			int empNo = 0;
			String empName = null;
			String empJob = null;
			double empSal = 0;
			if (sc != null) {
				System.out.print("Enter empno: ");
				empNo = sc.nextInt();
				// Consume the newline character left in the buffer
				System.out.print("Enter ename: ");
				empName = sc.next();
				System.out.print("Enter job: ");
				empJob = sc.next();
				System.out.print("Enter sal: ");
				empSal = sc.nextDouble();
			} // sc if end

			// SQL query content manage
			empName = "'" + empName + "'";
			empJob = "'" + empJob + "'";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			if (conn != null) {
				st = conn.createStatement();
//				SQL> insert into emp (empno,ename,job,sal) values (1001,'Shubham','Soft Engg',20000);
//				1 row created.
				String query = "INSERT INTO EMP (EMPNO,ENAME,JOB,SAL) VALUES (" + empNo + "," + empName + "," + empJob
						+ "," + empSal + ")";
				if (st != null) {
					int rowAffect = st.executeUpdate(query); // Executes the given SQL statement, which may be an
																// INSERT, UPDATE, or DELETE statement
					// or anSQL statement that returns nothing, such as an SQL DDL statement
					if (rowAffect == 0) {
						System.out.println("Data is not inserted ");
					} else {
						System.out.println("Data is inserted ");
					}
				} // st if end
			} // conn if end

		} catch (SQLException se) {
			se.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {

			// close connections
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
