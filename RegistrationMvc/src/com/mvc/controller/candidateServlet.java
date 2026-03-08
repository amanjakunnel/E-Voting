package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.candidateBean;
import com.mvc.dao.candidateDao;
public class candidateServlet extends HttpServlet {
	  
    public candidateServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //Copying all the input parameters in to local variables
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String candidateId = request.getParameter("candidateId");
        String password = request.getParameter("password");
        String constituency = request.getParameter("constituency");
        String party=request.getParameter("party");
         
        candidateBean can_inst = new candidateBean();
       //Using Java Beans - An easiest way to play with group of related data
        can_inst.setFullName(fullName);
        can_inst.setEmail(email);
        can_inst.setCandidateId(candidateId);
        can_inst.setPassword(password); 
        can_inst.setConstituency(constituency);
        can_inst.setParty(party);
        candidateDao dao_inst = new candidateDao();
         
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String candidateRegistered = dao_inst.registerCandidate(can_inst);
         
        if(candidateRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
           request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
           request.setAttribute("errMessage", candidateRegistered);
           //request.getRequestDispatcher("/error.jsp").forward(request, response);
           response.sendRedirect("error.jsp");
        }
    }
}