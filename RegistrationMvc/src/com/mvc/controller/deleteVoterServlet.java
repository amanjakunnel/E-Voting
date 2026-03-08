package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.voterBean;
import com.mvc.dao.voterDao;

public class deleteVoterServlet extends HttpServlet {


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    
	

	 voterBean voter_inst = new voterBean();
     voter_inst.setVoterId(request.getParameter("voterId"));
     
     voterDao voter_dao_inst = new voterDao();

     String ret_val = voter_dao_inst.deleteVoter(voter_inst);
	   		    
     if (ret_val=="SUCCESS")
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",voter_inst); 
          response.sendRedirect("voterDelSuccess.jsp"); //logged-in page      		
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