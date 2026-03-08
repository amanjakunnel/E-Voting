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

public class updateVoterServlet extends HttpServlet {


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    
	

	 voterBean voter_inst = new voterBean();
     voter_inst.setVoterId(request.getParameter("voterId"));
     voter_inst.setFullName(request.getParameter("fullname"));
     voter_inst.setEmail(request.getParameter("email"));
     voter_inst.setPassword(request.getParameter("password"));
     voter_inst.setConstituency(request.getParameter("constituency"));
     
     voterDao voter_dao_inst = new voterDao();

     String ret_val = voter_dao_inst.updateVoter(voter_inst);
	   		    
     if (ret_val=="SUCCESS")
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",voter_inst); 
          response.sendRedirect("voterUpSuccess.jsp"); //logged-in page      		
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