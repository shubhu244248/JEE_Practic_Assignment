package com.db.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBSearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		resp.setContentType("text/html");

		int EmpNo = Integer.parseInt(req.getParameter("eno"));

		// JDBC Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection("jdbc:mysql:///employee", "root", "admin");
				PreparedStatement ps = conn.prepareStatement("SELECT eid, fname, lname FROM employee WHERE eid = ?")) {
			if (ps != null) {
				ps.setInt(1, EmpNo);
			}
			try (ResultSet rs = ps.executeQuery()) {
				if (rs != null) {
					if (rs.next()) {
						pw.println("<p style='text-align: center'>");
						pw.println("<h1 text-align: center> Employee Details are :");
						pw.println(rs.getString(1));
						pw.println(rs.getString(2));
						pw.println(rs.getString(3));
						pw.println(" </h1></p>");
					} else {
						pw.println("<p style='text-align: center;'><h1 text-align: center> Employee Details Not Found :");
						pw.println(" </h1></p>");
					}
				}
				
				pw.println("<br><br>");
			} catch (SQLException se) {
				se.printStackTrace();
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
