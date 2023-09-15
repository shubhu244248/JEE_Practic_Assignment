package com.workingWithDate.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JdbcDateWorking {

	public static void main(String[] args) throws ParseException {

		// Converting data value to java.util.Data class obj 
		String date = "21-11-1990";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date ud = sdf.parse(date);
		System.out.println("String data value "+ date);
		System.out.println("util date "+ud);
		
		//converting java.util.Date clas obj to java.sql.Date class obj
		long ms = ud.getTime(); // it gives epoch standard date and time 1970 jav 1st mid night 00:00 hrs
		
		java.sql.Date sd = new java.sql.Date(ms);
		System.out.println("util date "+ ud);
		System.out.println("sql date "+sd);
		
		// if String date values patter is yyyy-MM-dd patter then it can be convert directly to java.sql.Date class obj with out converting to java.util.Date class obj
		String date1 = "1991-12-25";  // String date1 = "1991-12-25"; it gives illegal argument exception
		java.sql.Date sd1 = java.sql.Date.valueOf(date1);
		System.out.println("sql Date value "+sd1);
		System.out.println("String Date value "+date1);
		
	}

}
