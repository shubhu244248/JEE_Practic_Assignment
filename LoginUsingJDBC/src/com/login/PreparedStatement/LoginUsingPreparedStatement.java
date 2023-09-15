package com.login.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginUsingPreparedStatement {

	private static final String query = "SELECT COUNT(*) FROM LOGINUSER WHERE UNAME =? AND UPASS =?";

	public static void main(String[] args) {

//		select count(*) from LoginUser where uname =" + uname + " and upass =" + upass
		Scanner sc = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			sc = new Scanner(System.in);
			String uName = null;
			String uPass = null;
			if (sc != null) {
				System.out.print("Enter username ");
				uName = sc.next();
				System.out.print("Enter username ");
				uPass = sc.next();
			} // sc ennd

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

			if (conn != null) {
				pst = conn.prepareStatement(query);

				if (pst != null) {
					pst.setString(1, uName);
					pst.setString(2, uPass);
				} // pst snd
			} // conn end

			// credential validation SQL injection is not happen wile using the
			// preparedstatement interface
			int rowRowAffected = pst.executeUpdate();
			if (rowRowAffected == 0) {
				System.out.println("Envalid credentials ");
			} else {
				System.out.println("Valid credentials ");
			}

		} catch (SQLException se) {
			se.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			// close connection
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception e2) {
				e2.getStackTrace();
			}
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e2) {
				e2.getStackTrace();
			}
			try {
				if (conn != null) {
				}
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}

}
