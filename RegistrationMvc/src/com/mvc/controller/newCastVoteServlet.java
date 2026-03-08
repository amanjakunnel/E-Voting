package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.candidateBean;
import com.mvc.dao.candidateDao;
import com.mvc.bean.voterBean;
import com.mvc.dao.voterDao;
import com.mvc.util.DBConnection;

public class newCastVoteServlet extends HttpServlet {

	
public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, java.io.IOException {
	 PrintWriter out = response.getWriter();  
     response.setContentType("text/html");
     out.println("<html><body><center><table border=\"1\">\r\n"
     		+ "<tr>\r\n"
     		+ "  <th>Full Name</th>\r\n"
     		+ "  <th>Email</th>\r\n"
     		+ "  <th>Candidate ID</th>\r\n"
     		+ "  <th>Constituency</th>\r\n"
     		+ "  <th>Party</th>\r\n"
     		+ "</tr>");
    	 try {
   			Connection con = DBConnection.createConnection();
   			String q = "Select * from candidates";
   			PreparedStatement ps = con.prepareStatement(q);
   			ResultSet rs = ps.executeQuery();
   			while(rs.next()) {
   				out.println("<tr>\r\n"
   						+ "  <td>"+rs.getString(2)+"</td>\r\n"
   						+ "  <td>"+rs.getString(3)+"</td>\r\n"
   						+ "  <td>"+rs.getString(4)+"</td>\r\n"
   						+ "  <td>"+rs.getString(6)+"</td>\r\n"
   						+ "  <td>"+rs.getString(7)+"</td>\r\n"
   						+ "</tr>");
   			}
   			out.println("</center></body></html>");
   		}
   		catch(Exception e) {
   			e.printStackTrace();
   			}

     out.println("</table></center></body></html>");
 
}


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
	
        	 
try
{	    
	

	 candidateBean can_inst = new candidateBean();
	 voterBean voter_inst = new voterBean();
     can_inst.setCandidateId(request.getParameter("candidateId"));
     voter_inst.setVoterId(request.getParameter("voterId"));
     
     voterDao voter_dao_inst = new voterDao();

     String ret_val = voter_dao_inst.castVote(voter_inst,can_inst);
     String ret=voter_dao_inst.castDel(voter_inst);
	   		    
     if ((ret_val=="SUCCESS")&&(ret=="SUCCESS"))
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",can_inst); 
          response.sendRedirect("voteSuccessful.jsp"); //logged-in page      		
     }
	        
     else 
          response.sendRedirect("error.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
	}
}