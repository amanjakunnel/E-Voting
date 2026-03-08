package com.mvc.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.candidateDao;
import com.mvc.util.DBConnection;
 

public class viewVoterServlet extends HttpServlet {
  
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
    	 PrintWriter out = response.getWriter();  
         response.setContentType("text/html");
         out.println("<html><body><center><table border=\"1\">\r\n"
         		+ "<tr>\r\n"
         		+ "  <th>Full Name</th>\r\n"
         		+ "  <th>Email</th>\r\n"
         		+ "  <th>Voter ID</th>\r\n"
         		+ "  <th>Constituency</th>\r\n"
         		+ "</tr>");
        	 try {
       			Connection con = DBConnection.createConnection();
       			String q = "Select * from voters";
       			PreparedStatement ps = con.prepareStatement(q);
       			ResultSet rs = ps.executeQuery();
       			while(rs.next()) {
       				out.println("<tr>\r\n"
       						+ "  <td>"+rs.getString(2)+"</td>\r\n"
       						+ "  <td>"+rs.getString(3)+"</td>\r\n"
       						+ "  <td>"+rs.getString(4)+"</td>\r\n"
       						+ "  <td>"+rs.getString(6)+"</td>\r\n"
       						+ "</tr>");
       			}
       			out.println("</center></body></html>");
       		}
       		catch(Exception e) {
       			e.printStackTrace();
       			}
 
         out.println("</table></center></body></html>");
     
     }
}