package com.forms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formurl")
public class AllFormCompServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");
		// read form data
		String name = req.getParameter("pname");
		String addrs = req.getParameter("paddrs");
		int age = Integer.parseInt(req.getParameter("page"));
		String gender = req.getParameter("gender");
		String ms = req.getParameter("ms");
		ms = (ms == null) ? "single" : ms;
		String qlfy = req.getParameter("qlfy");
		String languages[] = req.getParameterValues("languages");
		if (languages == null)
			languages = new String[] { " no languaes are selected" };

		String hobies[] = req.getParameterValues("hb");
		if (hobies == null)
			hobies = new String[] { " no hobies are selected" };

		String dob = req.getParameter("dob");
		String tob = req.getParameter("tob");
		String month = req.getParameter("mob");
		String wdb = req.getParameter("wdb");
		int favNumber = Integer.parseInt(req.getParameter("favNumber"));
		long mobileNo = Long.parseLong(req.getParameter("mobileNo"));
		String mail = req.getParameter("mail");
		String favColor = req.getParameter("favColor");
		int income = Integer.parseInt(req.getParameter("income"));
		String url = req.getParameter("fburl");
		String favSS = req.getParameter("favSearch");
		// write business logic

		pw.println("<html><head><title>Form Response</title>");
		pw.println(
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
		pw.println("</head><body class='container mt-5'>");
		pw.println("<div class='row justify-content-center'>");
		pw.println("<div class='col-md-6'>");

		if (gender.equalsIgnoreCase("M")) {
			pw.println("<h1 class='text-center text-primary'>Hello, " + name + "</h1>");
			if (age < 5)
				pw.println("<p class='text-center'>You are a baby boy</p>");
			else if (age < 13)
				pw.println("<p class='text-center'>You are a small boy</p>");
			else if (age < 19)
				pw.println("<p class='text-center'>You are a teenage boy</p>");
			else if (age < 35)
				pw.println("<p class='text-center'>You are a young man</p>");
			else if (age < 50)
				pw.println("<p class='text-center'>You are a middle-aged man</p>");
			else
				pw.println("<p class='text-center'>You are an older man</p>");
		} else {
			pw.println("<h1 class='text-center text-primary'>Hello, " + name + "</h1>");
			if (age < 5)
				pw.println("<p class='text-center'>You are a baby girl</p>");
			else if (age < 13)
				pw.println("<p class='text-center'>You are a small girl</p>");
			else if (age < 19) {
				if (ms.equalsIgnoreCase("married"))
					pw.println("<p class='text-center'>You are a teenage married girl</p>");
				else
					pw.println("<p class='text-center'>You are a teenage girl</p>");
			} else if (age < 35) {
				if (ms.equalsIgnoreCase("married"))
					pw.println("<p class='text-center'>You are a young married girl</p>");
				else
					pw.println("<p class='text-center'>You are a young girl</p>");
			} else if (age < 50) {
				if (ms.equalsIgnoreCase("married"))
					pw.println("<p class='text-center'>You are a middle-aged woman</p>");
				else
					pw.println("<p class='text-center'>You are a middle-aged woman</p>");
			} else {
				if (ms.equalsIgnoreCase("married"))
					pw.println("<p class='text-center'>You are an older married woman</p>");
				else
					pw.println("<p class='text-center'>You are an older woman</p>");
			}
		}

		// Display form data
		pw.println("<h3 class='text-primary'>Form Data</h3>");
		pw.println("<p><strong>Name:</strong> " + name + "</p>");
		pw.println("<p><strong>Age:</strong> " + age + "</p>");
		pw.println("<p><strong>Address:</strong> " + addrs + "</p>");
		pw.println("<p><strong>Gender:</strong> " + gender + "</p>");
		pw.println("<p><strong>Marital Status:</strong> " + ms + "</p>");
		pw.println("<p><strong>Qualification:</strong> " + qlfy + "</p>");
		pw.println("<p><strong>Languages Known:</strong> " + Arrays.toString(languages) + "</p>");
		pw.println("<p><strong>Hobbies:</strong> " + Arrays.toString(hobies) + "</p>");
		pw.println("<p><strong>DOB:</strong> " + dob + "</p>");
		pw.println("<p><strong>TOB:</strong> " + tob + "</p>");
		pw.println("<p><strong>Month of Birth:</strong> " + month + "</p>");
		pw.println("<p><strong>Week of Birth:</strong> " + wdb + "</p>");
		pw.println("<p><strong>Fav Color:</strong> " + favColor + "</p>");
		pw.println("<p><strong>Search String:</strong> " + favSS + "</p>");
		pw.println("<p><strong>Income:</strong> " + income + "</p>");
		pw.println("<p><strong>Mobile Number:</strong> " + mobileNo + "</p>");
		pw.println("<p><strong>Email:</strong> " + mail + "</p>");
		pw.println("<p><strong>Fav Number:</strong> " + favNumber + "</p>");
		pw.println("<p><strong>FB URL:</strong> " + url + "</p>");

		// Add a link to the home page
		pw.println("<br><a class='btn btn-primary' href='all_comp_form.html'>Back to Home</a>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("</div>"); // Close the col-md-6
		pw.println("</div>"); // Close the row

		pw.println("</body></html>");
		// close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
