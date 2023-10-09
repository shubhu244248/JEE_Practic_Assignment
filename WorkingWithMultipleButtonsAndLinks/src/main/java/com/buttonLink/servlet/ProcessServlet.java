package com.buttonLink.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter(); // get PrintWriter

		resp.setContentType("text/html"); // set response content type

		// read special request parameter values
		String s1val = req.getParameter("s1");

		// read form data (text box)
		int val1 = 0;
		int val2 = 0;

		// read text box data onlly when request is not from hyperlink
		if (!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link2")) {
			val1 = Integer.parseInt(req.getParameter("t1"));
			val2 = Integer.parseInt(req.getParameter("t2"));
		}

		// diff logic for submit button and links
		if (s1val.equalsIgnoreCase("add")) {
			pw.println("<h1> Sum of " + val1 + " and " + val2 + "is :" + (val1 + val2) + "</h1>");
		} else if (s1val.equalsIgnoreCase("sub")) {
			pw.println("<h1> Sub of " + val1 + " and " + val2 + "is :" + (val1 - val2) + "</h1>");
		} else if (s1val.equalsIgnoreCase("mul")) {
			pw.println("<h1> Mul of " + val1 + " and " + val2 + "is :" + (val1 * val2) + "</h1>");
		} else if (s1val.equalsIgnoreCase("div")) {
			pw.println("<h1> Div of " + val1 + " and " + val2 + "is :" + ((float) val1 / val2) + "</h1>");
		} else if (s1val.equalsIgnoreCase("link1")) {
			pw.println("<h1> System Properties </h1>");
			pw.println(System.getProperties());
		} else {
			pw.println("<h1> System Properties </h1>");
			pw.println(LocalDateTime.now());
		}
		
		pw.println("<br><a href='index.html'>Home</a>");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
