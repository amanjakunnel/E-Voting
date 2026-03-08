package com.mvc.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.adminBean;
import com.mvc.util.DBConnection;
 
public class adminDao { 
     public String loginAdmin(adminBean admin_inst)
     {
    	 String employeeId=admin_inst.getEmployeeId();
    	 String password = admin_inst.getPassword();
    	 Connection con = null;
    	 ResultSet rs = null;
    	 //PreparedStatement preparedStatement = null;
    	 Statement stmt = null;
    	 try
    	 {
    		 con = DBConnection.createConnection();
    		 String query =  "select * from admin where employeeId='"
                     + employeeId
                     + "' AND password='"
                     + password
                     + "'";
    		 stmt=con.createStatement();
             rs = stmt.executeQuery(query);
             System.out.println("Your EMPLOYEE ID is " + employeeId);          
             System.out.println("Your password is " + password);
             System.out.println("Query: "+query);
             if (rs!=null)
            	 return "SUCCESS";
    	 }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";
    }
     public void delete_voter(int voterId) {
 		
 		try {
   			Connection con = DBConnection.createConnection();
   			String q = "delete from voters where voterId=?";
   			PreparedStatement ps = con.prepareStatement(q);
   			ps.setInt(1,voterId);
   			ResultSet rs = ps.executeQuery();
   			
   		}
   		catch(Exception e) {
   			e.printStackTrace();
   		}
     }
}