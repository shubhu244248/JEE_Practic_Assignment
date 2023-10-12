package com.crudJdbcOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class CRUDMainClass {
	private static final String url = "jdbc:mysql://localhost:3306/crud_data";
	private static final String username = "root";
	private static final String password = "admin";

	public static void CreateTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement smt = conn.createStatement();
		String create = "create table student (id int, name varchar(20),course varchar(20))";
		smt.executeUpdate(create);
		System.out.println("Table has been created");
		smt.close();
		conn.close();
	}

	public static void InsertTableData(int id, String name, String course) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String insert = "insert into student (id,name,course) values (?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(insert);
		psmt.setInt(1, id);
		psmt.setString(2, name);
		psmt.setString(3, course);
		psmt.executeUpdate();
		System.out.println("Data insert in table");
		psmt.close();
		conn.close();
	}

	public static void RetriveTableData() throws ClassNotFoundException, SQLException {
		ArrayList<CRUDStudent> al = new ArrayList<CRUDStudent>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String select = "select * from student";
		Statement smt = conn.createStatement();
		ResultSet rs = smt.executeQuery(select);
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String course = rs.getString("course");
			
//			System.out.println("ID "+id); Simple method 
//			System.out.println("Name "+name);
//			System.out.println("Course "+course);
			
			
			
			CRUDStudent std = new CRUDStudent(id, name, course);
			al.add(std);
			
		}
		
		for(CRUDStudent la : al) {
			System.out.println(la);
//			System.out.println(la.getId());
//			System.out.println(la.getName());
//			System.out.println(la.getCourse());
		}
			
	}

	public static void UpdateTableData(int id, String course) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String update = "update student set course = ? where id = ?";
		PreparedStatement psmt = conn.prepareStatement(update);
		psmt.setString(1, course);
		psmt.setInt(2, id);
		psmt.executeUpdate();
		System.out.println("Data is updated in table");
		psmt.close();
		conn.close();

	}

	public static void DeleteTableData(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String update = "delete from student where id = ?";
		PreparedStatement psmt = conn.prepareStatement(update);
		psmt.setInt(1, id);
		psmt.executeUpdate();
		System.out.println("User id is deleted");
		psmt.close();
		conn.close();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("If you already created table then you need the press 2 othervise 1");
		System.out.println("Press 1 or 2");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (num == 1) {
			CreateTable();
		} else {
			int op = sc.nextInt();
			switch (op) {
			case 1:
//				InsertTableData(1, "Shubham Patil", "Java");
				InsertTableData(2, "Nikita Patil", "J2EE");
				break;
			case 2:
				UpdateTableData(2, "Java");
				break;
			case 3:
				DeleteTableData(2);
				break;
			case 4:
				RetriveTableData();
				break;
			}

		}
	}

}
