package com.search.requestdispacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {

	private static final String GET_EMP_BY_ENO = "SELECT eid, fname, lname FROM employee WHERE eid =?";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = null;
		try {
			// get PrintWriter
			pw = resp.getWriter();
			// set response content type
			resp.setContentType("text/html");

			// include header content using RequestDispacher
			RequestDispatcher rd1 = req.getRequestDispatcher("/headurl");
			rd1.include(req, resp);

			// get access to ServletConfig object
			ServletConfig cg = getServletConfig();

			System.out.println("EmpSearchSevlet's ServletConfig obj hashcode::" + cg.hashCode());
			
			// read Servlet init param values
			String driver = cg.getInitParameter("JdbcDriver");
			String url = cg.getInitParameter("url");
			String user = cg.getInitParameter("username");
			String pwd = cg.getInitParameter("password");

			// read form data
			int empNo = Integer.parseInt(req.getParameter("eno"));
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(url, user, pwd);
					PreparedStatement ps = conn
							.prepareStatement("SELECT eid, fname, lname FROM employee WHERE eid = ?")) {
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
							pw.println("<br><a href='search.html'>Home</a>");
							pw.println("</h1>");

						} else {
							pw.println("<h1 style='text-align: center;'> Employee Details are <b>Not Found</b> ");
							pw.println("<br><a href='search.html'>Home</a> </h1>");
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
			// include footer content
			RequestDispatcher rd2 = req.getRequestDispatcher("/footer.html");
			rd2.include(req, resp);
			// close stream
			pw.close();
		} // try
		catch (Exception e) {
			e.printStackTrace();

			pw.println("<b> before rd.forward(-,-) </b>");
			System.out.println("MainServlet:: before rd.forward(req,res)");

			RequestDispatcher rd = req.getRequestDispatcher("errorurl");
			rd.forward(req, resp);

			pw.println("<b> after rd.forward(-,-) </b>");
			System.out.println("MainServlet:: after rd.forward(req,res)");
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
