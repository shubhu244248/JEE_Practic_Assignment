package com.OracleDBOperation.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class EmpDetailsStatement {

	private static final String query = "SELECT EMP_ID, EMP_MAIL, EMP_FIRST_NAME, EMP_LAST_NAME, EMP_ROLE, EMP_SAL, JOIN_DATE FROM EMP_INFO WHERE EMP_ID=?";
	private static final String driver = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static void main(String[] args) {
		int emp_no = 0;
		try(Scanner  sc = new Scanner(System.in);) {
			if(sc != null) {
				System.out.println("Enter emp_id : ");
				emp_no = sc.nextInt();
			}
			
			try (Connection conn = DriverManager.getConnection(driver, "system", "admin");
					Statement st = conn.createStatement()){
				if(st != null) {
					
				}
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
