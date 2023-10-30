package com.searchBar.sendRedirectUsingSendRedirectMethod;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

		// send hyperlink to browser having url to complete senRedirection
		String url = null;

		if (serachEngine.equalsIgnoreCase("google"))
			url = "https://www.google.com/search?q=" + seachString;
		else if (serachEngine.equalsIgnoreCase("bing"))
			url = "https://www.bing.com/search?q=" + seachString;
		else
			url = "https://in.search.yahoo.com/search?p=" + seachString;

		// peform sendDirection
		System.out.println("before res.sendRedirect(-)");
		pw.println("<b> hello </b>");
		resp.sendRedirect(url);
		// res.sendRedirect("abc.html");
		RequestDispatcher rd = req.getRequestDispatcher("/abc.html");
		rd.include(req, resp);
		System.out.println("after res.sendRedirect(-)");
		pw.println("<b> hai </b>");

		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
