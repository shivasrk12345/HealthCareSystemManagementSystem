<%@page import="com.tcs.bean.Patient"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All details of Patients</title>
<style>


table{
border-collapse:collapse;

color:white ;



}
.aside_right1
{
	
	height:450px;
	overflow:hidden;
	padding-left:1em;
	border-bottom:1px solid black;
	text-align:center;
	background-color:grey;
	
}
tr:nth-child(even){
background-color:black;
}
tr:nth-child(odd){
background-color:lightgrey;
color:black;
}
th{
background-color:powderblue;
color:navy;
}
</style>
</head>
<body>
<center>


<div class=main>
<div class=header>
	<div class=header_left>
	<img src="CSS/logo.jpg" alt="LOGO" height="100px" width="200px">
	</div>
	<div class=header_right>Patient And Health Care Service Management
	</div>
</div>
<div class=nav>
<ul>
<li><a href="<%= request.getContextPath()%>/Controller?action=home">HOME</a></li>
  <li><a href="<%= request.getContextPath()%>/Controller?action=aboutus">ABOUT US</a></li>
 <li><a href="<%= request.getContextPath()%>/Controller?action=contactus">CONTACT US</a></li>
  <li><a href="<%= request.getContextPath()%>/Controller?action=viewlsp">VIEWLSP</a></li>
   <li><a href="<%= request.getContextPath()%>/Controller?action=logout">LOG OUT</a></li>
  
  
</ul>
</div>
<div class=aside>
<div class=aside_left>
<a href="<%= request.getContextPath()%>/Controller?action=viewpatients">View Patient Profile</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=viewProfile">View Patient By ID OR Mobile Number</a><br><br>
</div>
<div class=aside_right1>
<br><center>
<%

String message=(String)request.getAttribute("Message");
ArrayList<Patient> plist =(ArrayList<Patient>)request.getAttribute("Patientlist");
if(message!=null&&plist!=null){
%>

<span style="color:green"><%=message %></span>
<table border=1 cellpadding=10>



<tr>
<th>PatientId</th>
<th>First Name</th>
<th>Last Name</th>
<th>Mobile Number</th>
</tr>
<%for(Patient p:plist){ %>
<tr>
<td><%=p.getPatientId() %></td>
<td><%=p.getFirstName() %></td>
<td><%=p.getLastName() %></td>
<td><%=p.getContactNumber() %></td>
</tr>

<%}} %>
</table>
</center>
</div>
</div>

<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>

</center>
</body>
</html>