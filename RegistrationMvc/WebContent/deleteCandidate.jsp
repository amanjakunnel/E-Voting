 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidate-Registration</title>
<script> 
function validate()
{ 
     var candidateId = document.form.candidateId.value; 
      
     if (candidateId==null || candidateId=="")
     { 
     alert("Candidate ID can't be blank"); 
     return false; 
     }
 }
function alert() {
	  let text;
	  if (confirm("Press a button!") == true) {
	    text = "You pressed OK!";
	  } else {
	    text = "You canceled!";
	  }
	  document.getElementById("demo").innerHTML = text;
	}
</script> 
</head>
<body>
<center><h2>Delete a Candidate </h2></center>
    <form name="form" action="deleteCandidateServlet" method="post" onsubmit="return validate()">
        <table align="center">
         <tr>
         <td>Enter Candidate ID to delete</td>
         <td><input type="text" name="candidateId" /></td>
         </tr>
         <tr>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="Delete"></input><input
         type="reset" value="Reset"></input></td>
         </tr>
        </table>
    </form>
</body>
</html>