package com.voting.eligibility;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EligibilityCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter(); // get printwriter

		resp.setContentType("text/html"); // set content type as html and text

		String pcheck = req.getParameter("check"); //special request parameter 
//		System.out.println(pcheck);
		
		String pname = req.getParameter("name"); // get name
//		System.out.println(pname);

		int page = Integer.parseInt(req.getParameter("age")); // get age and parse into integer 
//		System.out.println(page);

		if (pcheck.equalsIgnoreCase("Click Here")) {
			pw.println("<h1>Chech Your Status</h1>");
			if (page < 18) {
				int ageCriteria = 18;
				ageCriteria = ageCriteria - page;
				pw.println("<br>");
				pw.println("<h1> Mr/Miss " + pname + " you are Not Eligible for voting please wait. Your age is "
						+ page + " and for satisfy the  criteria wait for " + ageCriteria + " years. </h1>");
			} else if( page >=18 && page <=125){
				pw.println("<br>");
				pw.println("<h1> Mr/Miss " + pname + " you are Eligible for voting please do registeer. Your age is "
						+ page + " and It is satisfy the  criteria. </h1>");
			} 
			else {
				
			}
		}
		pw.println("<br><a href='index.html'>Home</a>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
