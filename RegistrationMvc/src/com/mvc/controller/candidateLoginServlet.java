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

public class candidateLoginServlet extends HttpServlet {


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    
	

	 candidateBean can_inst = new candidateBean();
     can_inst.setCandidateId(request.getParameter("candidateId"));
     can_inst.setPassword(request.getParameter("password"));
     
     candidateDao can_dao_inst = new candidateDao();

     String ret_val = can_dao_inst.loginCandidate(can_inst);
	   		    
     if (ret_val=="SUCCESS")
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",can_inst); 
          response.sendRedirect("candidateOptions.jsp"); //logged-in page      		
     }
	        
     else 
          response.sendRedirect("invalidLogin.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
	}
}