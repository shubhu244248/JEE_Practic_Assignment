package com.OracleDBOperation.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//SELECT EMP_ID, EMP_MAIL, EMP_FIRST_NAME, EMP_LAST_NAME, EMP_ROLE, EMP_SAL, JOIN_DATE FROM EMP_INFO WHERE EMP_ID=

public class FindEmployeeInfoByEmpID {

	private static final String query = "SELECT EMP_ID, EMP_MAIL, EMP_FIRST_NAME, EMP_LAST_NAME, EMP_ROLE, EMP_SAL, JOIN_DATE FROM EMP_INFO WHERE EMP_ID=?";

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);) {

			int emp_id = 0;
			if (sc != null) {
				System.out.println("Enter Employee ID : ");
				emp_id = sc.nextInt();
			}
			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
					"admin"); PreparedStatement pst = conn.prepareStatement(query);) {
				try (ResultSet rs = pst.executeQuery();) {
					while (rs.next()) {
						System.out.println(rs.getInt(1));
					}
				} // try 3
			} // try 2
		} // try 1
		catch (SQLException se) {
			se.getStackTrace();
			System.out.println("Something wents wrong....");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
