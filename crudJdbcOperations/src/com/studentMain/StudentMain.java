package com.studentMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentMain {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbcdbStudent";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";

	// create the student table
	public static void createTable() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement()) {

			String createTableSQL = "CREATE TABLE student (" + "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "name VARCHAR(50)," + "course VARCHAR(50) DEFAULT 'java'," + "email VARCHAR(100) NOT NULL)";

			statement.executeUpdate(createTableSQL);
			System.out.println("Student table created successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete a row from the student table by id
	public static void deleteRow(int id) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = ?")) {

			preparedStatement.setInt(1, id);
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Row with id " + id + " deleted successfully.");
			} else {
				System.out.println("No rows found with id " + id + ".");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update a row in the student table by id
	public static void updateRow(int id, String name, String course, String email) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE student SET name = ?, course = ?, email = ? WHERE id = ?")) {

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, course);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(4, id);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Row with id " + id + " updated successfully.");
			} else {
				System.out.println("No rows found with id " + id + ".");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// insert in the student table
	public static void insertData(String name, String course, String email) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO student (name, course, email) VALUES (?, ?, ?)")) {

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, course);
			preparedStatement.setString(3, email);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Data inserted successfully.");
			} else {
				System.out.println("Failed to insert data.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		createTable();
		insertData("Palle", "Java", "palle@gmail.com");
		insertData("Reshmi", "Java", "reshmi@gmail.com");
		deleteRow(2);
		insertData("Reshmi", "Java", "reshmi@gmail.com");
		updateRow(3, "Reshmi", "C#", "reshmi@gmail.com");

	}
}