<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>E-Voting</title>
</head>
<body>
 <center><h2>Administrator Options</h2></center>
 <center>
 	<form action="viewVoterServlet" method="post">
 		<table>
 		 <tr>
         <td><input type="submit" value="View Voters"></input></td>
         </tr>
        </table>
    </form> 
 	<form action="voterRegistration.jsp">
 		<table>
 		 <tr>
         <td><input type="submit" value="Add Voter"></input></td>
         </tr>
        </table>
    </form>
    <form action="updateVoter.jsp">
 		<table>
 		 <tr>
         <td><input type="submit" value="Update Voter"></input></td>
         </tr>
        </table>
    </form>
    <form action="deleteVoter.jsp">
 		<table>
 		 <tr>
         <td><input type="submit" value="Delete Voter"></input></td>
         </tr>
        </table>
    </form> 
    <form action="viewCandidateServlet" method="post">
 		<table>
 		 <tr>
         <td><input type="submit" value="View Candidates"></input></td>
         </tr>
        </table>
    </form> 
    <form action="candidateRegistration.jsp">
 		<table>
 		 <tr>
         <td><input type="submit" value="Add Candidate"></input></td>
         </tr>
        </table>
    </form>
    <form action="updateCandidate.jsp">
 		<table>
 		 <tr>
         <td><input type="submit" value="Update Candidate"></input></td>
         </tr>
        </table>
    </form>
    <form action="deleteCandidate.jsp">
 		<table>
 		 <tr>
         <td><input type="submit" value="Delete Candidate"></input></td>
         </tr>
        </table>
    </form> 
    
</center>
</body>
</html>