package com.OracleDBOperatios.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTableData {

	public static void main(String[] args) {
//		SQL> delete from emp where empno =2005;
//
//		1 row deleted.
		Scanner sc = null;
		Connection conn = null;
		Statement st = null;
		try {
			sc = new Scanner(System.in);
			int empNo = 0;
			int empSal = 0;
			if (sc != null) {
				System.out.print("Which wmployee number details you want to delete ");
				empNo = sc.nextInt();

			} // sc ed

			// loading and registering Oracle driver
//			Class.forName(DriverPath) // optional

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

			if (conn != null) {
				st = conn.createStatement();
				// prepare sql query
				String query = "DELETE FROM EMP WHERE EMPNO =" + empNo;
				System.out.println(query);
				if (st != null) {
					int rowAffect = st.executeUpdate(query);
					if (rowAffect == 0) {
						System.out.println("Something wrong ");
					} else {
						System.out.println("Data deleted ");
					}
				} // st end
			} // conn end

		} catch (SQLException se) {
			se.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			// close connection 
			try {
				if (st != null) {
					sc.close();
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
			try {
				if (conn != null) {
					sc.close();
				}
			} catch (Exception e) {
				e.getStackTrace();
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
