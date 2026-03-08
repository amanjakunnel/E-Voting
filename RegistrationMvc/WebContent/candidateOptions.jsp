<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>E-Voting</title>
</head>
<body>
 <center><h2>Candidate Options</h2></center>
 <center>
 	<form action="results.jsp">
 		<table>
 		 <tr>
         <td><input type="submit" value="View Results"></input></td>
         </tr>
        </table>
    </form>
    <form action="updateManifesto.jsp">
 		<table>
 		 <tr>
         <td><input type="submit" value="Update Manifesto"></input></td>
         </tr>
        </table>
    </form>
    <form action="deleteCandidate.jsp">
 		<table>
 		 <tr>
         <td><input type="submit" value="Withdraw from Election"></input></td>
         </tr>
        </table>
    </form> 
</center>
</body>
</html>