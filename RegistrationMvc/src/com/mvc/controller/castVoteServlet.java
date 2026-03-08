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

public class castVoteServlet extends HttpServlet {


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
        //Copying all the input parameters in to local variables
    	 PrintWriter out = response.getWriter();  
         response.setContentType("text/html");
         out.println("<html><body><center>");
        	 
try
{	    
	

	 candidateBean can_inst = new candidateBean();
	 voterBean voter_inst = new voterBean();
     can_inst.setCandidateId(request.getParameter("candidateId"));
     voter_inst.setVoterId(request.getParameter("voterId"));
     
     voterDao voter_dao_inst = new voterDao();

     String ret_val = voter_dao_inst.castVote(voter_inst,can_inst);
	   		    
     if (ret_val=="SUCCESS")
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

protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    candidateDao dao = new candidateDao();

    try {

        List<candidateBean> listCandidate = dao.list();
        request.setAttribute("listCandidate", listCandidate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    } catch (SQLException e) {
        e.printStackTrace();
        throw new ServletException(e);
    }
}
}