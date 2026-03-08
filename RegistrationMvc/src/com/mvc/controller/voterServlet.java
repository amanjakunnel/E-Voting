package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mvc.bean.voterBean;
import com.mvc.dao.voterDao;
 
public class voterServlet extends HttpServlet {
  
     public voterServlet() {
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
         String fullName = request.getParameter("fullname");
         String email = request.getParameter("email");
         String voterId = request.getParameter("voterId");
         String password = request.getParameter("password");
         String constituency = request.getParameter("constituency");
          
         voterBean voter_inst = new voterBean();
        //Using Java Beans - An easiest way to play with group of related data
         voter_inst.setFullName(fullName);
         voter_inst.setEmail(email);
         voter_inst.setVoterId(voterId);
         voter_inst.setPassword(password); 
         voter_inst.setConstituency(constituency); 
          
         voterDao voterDaoInst = new voterDao();
          
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String userRegistered = voterDaoInst.registerUser(voter_inst);
          
         if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
         }
     }
}