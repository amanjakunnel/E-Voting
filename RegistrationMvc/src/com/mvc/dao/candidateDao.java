package com.mvc.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.candidateBean;
import com.mvc.util.DBConnection;
import java.sql.*;
 
public class candidateDao { 
     public String registerCandidate(candidateBean can_inst)
     {
         String fullName = can_inst.getFullName();
         String email = can_inst.getEmail();
         String candidateId = can_inst.getCandidateId();
         String password = can_inst.getPassword();
         String constituency = can_inst.getConstituency();
         String party = can_inst.getParty();
          
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into candidates(SlNo,fullName,Email,candidateId,password,constituency,party) values (NULL,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, fullName);
             preparedStatement.setString(2, email);
             preparedStatement.setString(3, candidateId);
             preparedStatement.setString(4, password);
             preparedStatement.setString(5, constituency);
             preparedStatement.setString(6, party);
              
             int i= preparedStatement.executeUpdate();
              
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
      return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
     }
     public String loginCandidate(candidateBean can_inst)
     {
    	 String candidateId=can_inst.getCandidateId();
    	 String password = can_inst.getPassword();
    	 Connection con = null;
    	 ResultSet rs = null;
    	 //PreparedStatement preparedStatement = null;
    	 Statement stmt = null;
    	 try
    	 {
    		 con = DBConnection.createConnection();
    		 String query =  "select * from candidates where candidateId='"
                     + candidateId
                     + "' AND password='"
                     + password
                     + "'";
    		 stmt=con.createStatement();
             rs = stmt.executeQuery(query);
             System.out.println("Your candidate ID is " + candidateId);          
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
     public String deleteCandidate(candidateBean can_inst)
     {
    	 Connection con = null;
    	 ResultSet rs = null;
    	 String candidateId=can_inst.getCandidateId();
    	 System.out.println("Your candidate ID is " + candidateId);
    	 
    	 //PreparedStatement preparedStatement = null;
    	 try
    	 {
    		 con = DBConnection.createConnection();
    		 String query="delete from candidates where candidateId=?";
    		 PreparedStatement ps = con.prepareStatement(query);
    		 ps.setString(1, candidateId);
    		 int i = ps.executeUpdate();
    		 if (i!=0)
    			 return "SUCCESS";
    		 
    	 }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";
    }
     public String updateCandidate(candidateBean can_inst)
     {
         String fullName = can_inst.getFullName();
         String email = can_inst.getEmail();
         String candidateId = can_inst.getCandidateId();
         String password = can_inst.getPassword();
         String constituency = can_inst.getConstituency();
         String party = can_inst.getParty();
          
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "UPDATE candidates SET fullName=? , Email=?, password=? , constituency =?, party=? WHERE candidateId=?"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, fullName);
             preparedStatement.setString(2, email);
             preparedStatement.setString(3, password);
             preparedStatement.setString(4, constituency);
             preparedStatement.setString(5, party);
             preparedStatement.setString(6, candidateId);
             
              
             int i= preparedStatement.executeUpdate();
              
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
     }
 
//     public List<candidateBean> list() throws SQLException {
//    	        List<candidateBean> listCandidate = new ArrayList<>();
//    	        
//    	        Connection con = null;
//    	         
//    	        try {
//    	        	
//    	        	con = DBConnection.createConnection();
//    	            String sql = "SELECT candidateId FROM candidates ORDER BY name";
//    	            Statement statement = con.createStatement();
//    	            ResultSet result = statement.executeQuery(sql);
//    	             
//    	            while (result.next()) {
//    	                String name = result.getString("candidateId");
//    	                candidateBean can_inst = new candidateBean();
//    	                can_inst.setCandidateId("candidateId");  
//    	                listCandidate.add(can_inst);
//    	            }          
//    	             
//    	        } catch (SQLException ex) {
//    	            ex.printStackTrace();
//    	            throw ex;
//    	        }      
//    	         
//    	        return listCandidate;
//    	    }
}