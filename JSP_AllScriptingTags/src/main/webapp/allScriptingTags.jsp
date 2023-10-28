<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!public String generateWishMessage(String user) {  // Declaration Tag
		LocalDateTime ldt = LocalDateTime.now();
		int hr = ldt.getHour();

		if (hr < 12) {
			return "Good Morning :: " + user;
		} else if (hr < 16) {
			return "Good Afternoon :: " + user;
		} else if (hr < 20) {
			return "Good Evening :: " + user;
		} else {
			return "Good Night :: " + user;
		}
	}%>

	<h1 style="text-align: center;">Welcome to JSP</h1>
	<br>
	<h1 style="text-align: center;">
		Date and Tome is ::
		<%=new Date()%></h1><!--  expression tag -->


	<%
	String name = "Shubham Patil"; /* Scriplet Tag */
	%>
	<br>
	<h1 style="text-align: center;">
		Wish You Happy ::
		<%=generateWishMessage(name)%>
		<!--  expression tag -->
	</h1>
</body>
</html>