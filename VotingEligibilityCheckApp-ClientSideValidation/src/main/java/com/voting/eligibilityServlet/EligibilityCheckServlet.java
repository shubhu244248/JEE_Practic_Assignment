package com.voting.eligibilityServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eligibilityurl")
public class EligibilityCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter(); // get printwriter

		resp.setContentType("text/html"); // set content type as html and text
		pw.println("<head>");
		pw.println(
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
		pw.println("</head>");
		pw.println("<body class='container'>");
		pw.println("<div class='justify-content-center'>");
		String pcheck = req.getParameter("checks"); // special request parameter
//		System.out.println(pcheck);

		String pname = req.getParameter("name"); // get name
//		System.out.println(pname);

		int page = Integer.parseInt(req.getParameter("age")); // get age and parse into integer
//		System.out.println(page);

		if (!pcheck.equalsIgnoreCase("Click Here")) {
			pw.println("<h1 class='display-4'>Check Your Status</h1>"); // Bootstrap display-4 class for a large header
			if (page < 18) {
				int ageCriteria = 18;
				ageCriteria = ageCriteria - page;
				pw.println("<div class='alert alert-danger' role='alert'>");
				pw.println("<h2 class='alert-heading'>Mr/Miss " + pname + " you are Not Eligible for voting</h2>");
				pw.println("<p>Your age is " + page + " and to satisfy the criteria, please wait for " + ageCriteria
						+ " years.</p>");
				pw.println("</div>");
			} else if (page >= 18 && page <= 125) {
				pw.println("<div class='alert alert-success' role='alert'>");
				pw.println("<h2 class='alert-heading'>Mr/Miss " + pname + " you are Eligible for voting</h2>");
				pw.println("<p>Your age is " + page + " and it satisfies the criteria.</p>");
				pw.println("<br><a href='https://voterportal.eci.gov.in/'>Do Register Here</a>");
				pw.println("</div>");
			}
		}
		pw.println("<br><a href='index.html'>Home</a>");
		pw.println("</div>"); // Close the row

		pw.println("</body></html>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
