package com.db.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DBSearchEmpConfig_InintParamServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();

		resp.setContentType("text/html");
		// get access to SrvletConfig obj
		ServletConfig servConfig = getServletConfig();

		// read servlet init param
		String driver = servConfig.getInitParameter("JdbcDriver");
		String url = servConfig.getInitParameter("url");
		String username = servConfig.getInitParameter("username");
		String password = servConfig.getInitParameter("password");

		// read form data
		int empNo = Integer.parseInt(req.getParameter("eno"));

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = conn.prepareStatement("SELECT eid, fname, lname FROM employee WHERE eid = ?")) {
			if (ps != null) {
				ps.setInt(1, empNo);
			}
			try (ResultSet rs = ps.executeQuery()) {
				if (rs != null) {
					if (rs.next()) {
						pw.println("<h1 style='text-align: center;'> Employee Details are : <br><br>");
						pw.println("<br> Employee No :: " + rs.getString(1) + "<br>");
						pw.println("Employee First Name :: " + rs.getString(2) + "<br>");
						pw.println("Employee Last Name :: " + rs.getString(3) + "<br>");
						pw.println("<br><a href='index.html'>Home</a>");
						pw.println("</h1>");

					} else {
						pw.println("<h1 style='text-align: center;'> Employee Details are <b>Not Found</b> ");
						pw.println("<br><a href='index.html'>Home</a> </h1>");
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
