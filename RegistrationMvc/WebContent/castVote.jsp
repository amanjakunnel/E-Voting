<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log-in</title>
<script> 
function validate()
{ 
     var voterId = document.form.voterId.value; 
     var candidateId = document.form.candidateId.value;

     if (voterId==null ||voterId=="")
     { 
     alert("Voter ID can't be blank"); 
     return false; 
     }
     else if (candidateId==null ||candidateId=="")
     { 
     alert("Candidate ID can't be blank"); 
     return false; 
     }
 } 
</script> 
</head>
<body>
<center><h2>Cast Vote </h2></center>
	
    <form name="form" action="castVoteServlet" method="post" onsubmit="return validate()">
        <table align="center">
        
         <tr>
         <td>Voter ID</td>
         <td><input type="text" name="voterId" /></td>
         </tr>
         
         <tr>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="Cast Vote"></input><input
         type="reset" value="Reset"></input></td>
         </tr>
        </table>
        Select a Category:&nbsp;
    	<select name="candidate">
        	<c:forEach items="${listCandidate}" >
            	<option value="${candidateId}">${candidateId}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <input type="submit" value="Submit" />
    </form>
    
</body>
</html>