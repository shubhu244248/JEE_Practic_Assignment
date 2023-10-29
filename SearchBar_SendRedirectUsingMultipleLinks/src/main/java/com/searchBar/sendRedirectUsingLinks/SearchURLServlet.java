package com.searchBar.sendRedirectUsingLinks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchURLServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		get Print Writter 
		PrintWriter pw = resp.getWriter();

		resp.setContentType("html/text");

//		read form data
		String seachString = req.getParameter("seachString");
		String serachEngine = req.getParameter("serachEngine");

//		send to perticular search engine using url of browser created 

		if (serachEngine.equalsIgnoreCase("google")) {
			pw.println(" <a href='https://www.google.com/search?q=" + seachString
					+"'> click here for google searach</a> ");
		} else if (serachEngine.equalsIgnoreCase("bing")) {
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.bing.com/search?q=" + seachString
					+ "'> click here for bing searach</a></h1> ");

		} else {
			pw.println("<h1 style='color:red;text-align:center'><a href='https://in.search.yahoo.com/search?p="
					+ seachString + "'> click here for yahoo searach</a></h1>");

		}

		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
