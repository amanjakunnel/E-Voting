package com.mvc.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.candidateBean;
import com.mvc.bean.voterBean;
import com.mvc.util.DBConnection;
 
public class voterDao { 
     public String registerUser(voterBean voter_inst)
     {
         String fullName = voter_inst.getFullName();
         String email = voter_inst.getEmail();
         String voterId = voter_inst.getVoterId();
         String password = voter_inst.getPassword();
         String constituency = voter_inst.getConstituency();
          
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into voters(SlNo,fullName,Email,voterId,password,constituency) values (NULL,?,?,?,?,?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, fullName);
             preparedStatement.setString(2, email);
             preparedStatement.setString(3, voterId);
             preparedStatement.setString(4, password);
             preparedStatement.setString(5, constituency);
              
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
     public String loginVoter(voterBean voter_inst)
     {
    	 String voterId=voter_inst.getVoterId();
    	 String password = voter_inst.getPassword();
    	 Connection con = null;
    	 ResultSet rs = null;
    	 //PreparedStatement preparedStatement = null;
    	 Statement stmt = null;
    	 try
    	 {
    		 con = DBConnection.createConnection();
    		 String query =  "select * from voters where voterId='"
                     + voterId
                     + "' AND password='"
                     + password
                     + "'";
    		 stmt=con.createStatement();
             rs = stmt.executeQuery(query);
             System.out.println("Your voter ID is " + voterId);          
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
     
     public String deleteVoter(voterBean voter_inst)
     {
    	 Connection con = null;
    	 ResultSet rs = null;
    	 String voterId=voter_inst.getVoterId();
    	 System.out.println("Your voter ID is " + voterId);
    	 
    	 //PreparedStatement preparedStatement = null;
    	 try
    	 {
    		 con = DBConnection.createConnection();
    		 String query="delete from voters where voterId=?";
    		 PreparedStatement ps = con.prepareStatement(query);
    		 ps.setString(1, voterId);
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
     
     public String updateVoter(voterBean voter_inst)
     {
         String fullName = voter_inst.getFullName();
         String email = voter_inst.getEmail();
         String voterId = voter_inst.getVoterId();
         String password = voter_inst.getPassword();
         String constituency = voter_inst.getConstituency();
         
          
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "UPDATE voters SET fullName=? , Email=?, password=?, constituency=? WHERE voterId=?"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, fullName);
             preparedStatement.setString(2, email);
             preparedStatement.setString(3, password);
             preparedStatement.setString(4, constituency);
             preparedStatement.setString(5, voterId);
              
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
     public String castVote(voterBean voter_inst,candidateBean can_inst)
     {
    	 String voterId=voter_inst.getVoterId();
    	 String candidateId = can_inst.getCandidateId();
    	 Connection con = null;
    	 ResultSet rs = null;
    	 //PreparedStatement preparedStatement = null;
    	 Statement stmt = null;
    	 PreparedStatement preparedStatement = null;
    	 try
    	 {
    		 con = DBConnection.createConnection();
    		 String query = "UPDATE votes SET votes=? WHERE voterId=? AND candidateId=?"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setInt(1, 1);
             preparedStatement.setString(2, voterId);
             preparedStatement.setString(3, candidateId);
              
             int i= preparedStatement.executeUpdate();
             System.out.println("Your voter ID is " + voterId);          
             System.out.println("Candidate voted for is " + candidateId);
             System.out.println("Query: "+query);
             if (i!=0)  //Just to ensure data has been inserted into the database
                 return "SUCCESS"; 
             }
             catch(SQLException e)
             {
                e.printStackTrace();
             }       
             return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
       }
     public String castDel(voterBean voter_inst)
     {
    	 Connection con = null;
    	 ResultSet rs = null;
    	 String voterId=voter_inst.getVoterId();
    	 System.out.println("Your voter ID is " + voterId);
    	 
    	 //PreparedStatement preparedStatement = null;
    	 try
    	 {
    		 con = DBConnection.createConnection();
    		 String query="delete from votes where voterId=? AND votes=?";
    		 PreparedStatement ps = con.prepareStatement(query);
    		 ps.setString(1, voterId);
    		 ps.setInt(2, 0);
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
}