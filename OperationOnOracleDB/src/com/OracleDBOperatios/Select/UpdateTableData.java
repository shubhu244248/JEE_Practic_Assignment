package com.OracleDBOperatios.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTableData {

	public static void main(String[] args) {

//		> update emp set ENAME='Shubham', JOB = 'clet', SAl=3000 where empno =      ;
//      1 row updated. 
		Scanner sc = null;
		Connection conn = null;
		Statement st = null;
		try {
			sc = new Scanner(System.in);
			int empNo = 0;
			String empName = null;
			String empJob = null;
			int empSal = 0;
			if (sc != null) {
				System.out.print("Which wmployee number details you want to update ");
				empNo = sc.nextInt();
				System.out.print("Enter emp name ");
				empName = sc.next();
				System.out.print("Enter emp job ");
				empJob = sc.next();
				System.out.print("Enter emp salary ");
				empSal = sc.nextInt();
			} // sc ed

			// SQL query details
			empName = "'" + empName + "'";
			empJob = "'" + empJob + "'";

			// loading and registering Oracle driver
//			Class.forName(DriverPath) // optional

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

			if (conn != null) {
				st = conn.createStatement();
				// prepare sql query
				String query = "UPDATE EMP SET ENAME = " + empName + ", JOB =" + empJob + ", SAl = " + empSal
						+ " WHERE EMPNO = " + empNo;
				System.out.println(query);
				if (st != null) {
					int rowAffect = st.executeUpdate(query);
					if (rowAffect == 0) {
						System.out.println("Something wrong ");
					} else {
						System.out.println("Data updated ");
					}
				} // st end
			} // conn end

		} catch (SQLException se) {
			se.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			// close objs
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
