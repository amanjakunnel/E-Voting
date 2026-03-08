package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.candidateBean;
import com.mvc.dao.candidateDao;

public class updateCandidateServlet extends HttpServlet {


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    
	

	 candidateBean can_inst = new candidateBean();
     can_inst.setCandidateId(request.getParameter("candidateId"));
     can_inst.setFullName(request.getParameter("fullname"));
     can_inst.setEmail(request.getParameter("email"));
     can_inst.setPassword(request.getParameter("password"));
     can_inst.setConstituency(request.getParameter("constituency"));
     can_inst.setParty(request.getParameter("party"));
     
     candidateDao can_dao_inst = new candidateDao();

     String ret_val = can_dao_inst.updateCandidate(can_inst);
	   		    
     if (ret_val=="SUCCESS")
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",can_inst); 
          response.sendRedirect("candidateUpSuccess.jsp"); //logged-in page      		
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