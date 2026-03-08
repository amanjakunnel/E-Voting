<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voter Update</title>
<script> 
function validate()
{ 
     var fullname = document.form.fullname.value;
     var email = document.form.email.value;
     var voterID = document.form.voterID.value; 
     var password = document.form.password.value;
     var conpassword= document.form.conpassword.value;
     var constituency = document.form.constituency.value;
      
     if (fullname==null || fullname=="")
     { 
     alert("Full Name can't be blank"); 
     return false; 
     }
     else if (email==null || email=="")
     { 
     alert("Email can't be blank"); 
     return false; 
     }
     else if (voterId==null || voterId=="")
     { 
     alert("Voter ID can't be blank"); 
     return false; 
     }
     else if(password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     } 
     else if (constituency==null || constituency=="")
     { 
     alert("Constituency can't be blank"); 
     return false; 
     }
 } 
</script> 
</head>
<body>
<center><h2>Voter Registration Portal </h2></center>
    <form name="form" action="updateVoterServlet" method="post" onsubmit="return validate()">
        <table align="center">
         <tr>
         <td>Enter Voter ID for whom you want to update</td>
         <td><input type="text" name="voterId" /></td>
         </tr>
         <tr>
         <td>Full Name</td>
         <td><input type="text" name="fullname" /></td>
         </tr>
         <tr>
         <td>Email</td>
         <td><input type="text" name="email" /></td>
         </tr>
         <tr>
         <td>Password</td>
         <td><input type="password" name="password" /></td>
         </tr>
         <tr>
         <td>Confirm Password</td>
         <td><input type="password" name="conpassword" /></td>
         </tr>
         <tr>
         <td>Constituency you belong to</td>
         <td><input type="text" name="constituency" /></td>
         </tr>
         <tr>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="Register"></input><input
         type="reset" value="Reset"></input></td>
         </tr>
        </table>
    </form>
</body>
</html>