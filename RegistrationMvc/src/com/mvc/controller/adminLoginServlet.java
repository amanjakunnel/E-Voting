package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.adminBean;
import com.mvc.dao.adminDao;

public class adminLoginServlet extends HttpServlet {


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    
	

	 adminBean admin_inst = new adminBean();
     admin_inst.setEmployeeId(request.getParameter("employeeId"));
     admin_inst.setPassword(request.getParameter("password"));
     
     adminDao admin_dao_inst = new adminDao();

     String ret_val = admin_dao_inst.loginAdmin(admin_inst);
	   		    
     if (ret_val=="SUCCESS")
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",admin_inst); 
          response.sendRedirect("adminOptions.jsp"); //logged-in page      		
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