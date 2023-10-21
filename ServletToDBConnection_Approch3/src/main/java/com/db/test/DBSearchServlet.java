package com.db.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBSearchServlet extends HttpServlet {
    
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    	PrintWriter pw = resp.getWriter();
        
    	resp.setContentType("text/html");
        
        int EmpNo = Integer.parseInt(req.getParameter("eno"));
        
        // Get the connection
        conn = getConn();
        
        if (conn != null) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT eid, fname, lname FROM employee WHERE eid = ?")) {
                ps.setInt(1, EmpNo);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        pw.println("<h1 style='text-align: center;'> Employee Details are : <br><br>");
                        pw.println("<br> Employee No :: " + rs.getString(1) + "<br>");
                        pw.println("Employee First Name :: " + rs.getString(2) + "<br>");
                        pw.println("Employee Last Name :: " + rs.getString(3) + "<br>");
                        pw.println("<br><a href='index.html'>Home</a>");
                        pw.println("</h1>");
                    } else {
                        pw.println("<h1 style='text-align: center;'> Employee Details are <b>Not Found</b> ");
                        pw.println("<br><a href='index.html'>Home</a> </h1>");
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            pw.println("<h1 style='text-align: center;'> Database Connection Failed</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    
    
    
    private static Connection conn;

    private static Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:mysql:///employee", "root", "admin");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return conn;
    }
    
    
    
}
