package com.wishmsg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get PrintWriter
		PrintWriter pw = resp.getWriter();

		// set responce content
		resp.setContentType("text/html");

		LocalDateTime ldt = LocalDateTime.now(); // give current date time

		int hr = ldt.getHour(); // get hrs

		if (hr < 12) {
			pw.println("<h1 style='text-align: center' > Date and Time is :" + ldt.now() + "</h1>");
			pw.println(" <h1 style='text-align: center' >Good Morning</h1>\r\n"
					+ "    <p style='text-align: center'  >Wake up with determination, go to bed with satisfaction.</p>");
		} else if (hr < 16) {
			pw.println("<h1 style='text-align: center' > Date and Time is :" + ldt.now() + "</h1>");

			pw.println("<h1 style='text-align: center' >Good Afternoon</h1>\r\n"
					+ "    <p style='text-align: center' >Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.</p>");
		} else if (hr < 20) {
			pw.println("<h1 style='text-align: center' > Date and Time is :" + ldt.now() + "</h1>");

			pw.println(" <h1 style='text-align: center'>Good Evening</h1>\r\n"
					+ "    <p style='text-align: center' >Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.</p>");
		} else {
			pw.println("<h1 style='text-align: center' > Date and Time is :" + ldt.now() + "</h1>");
			pw.println("<h1 style='text-align: center'>Good Night</h1>\r\n"
					+ "    <p style='text-align: center'>Tomorrow is a new day with no mistakes in it yet. Rest well and dream big.</p>");
		}

		pw.println("<br> <a href='index.html'>Home</a>");

		pw.close();
	}

}
