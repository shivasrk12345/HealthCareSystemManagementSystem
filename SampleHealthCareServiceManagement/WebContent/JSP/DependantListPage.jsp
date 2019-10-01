<%@page import="com.tcs.bean.Patient"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dependants</title>
<style>
button {
    background-color: #F1948A;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 50%;
}
div.c1
{
   height:200px;
   width:400px;
   background-color:lightpink;
   border-radius:10px;
   color:#154360;
   align:center;
} 
</style>
</head>
<body>
<center>

<form method="post" action="<%=request.getContextPath()%>/Controller" >
<div class=main>
<div class=header>
	<div class=header_left>
	<img src="CSS/logo.jpg" alt="LOGO" height="100px" width="200px">
	</div>
	<%Patient p=(Patient)session.getAttribute("Patient"); %>
	<div class=header_right>Patient And Health Care Service Management
	<%if(session.getAttribute("username").equals(p.getFirstName())) {
	%> 
	<p align="right" style="font-size:20px;font-style: italic;">WELCOME  <%=p.getFirstName() %> <%=p.getLastName() %></p><br>
	
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
<a href="<%= request.getContextPath()%>/Controller?action=viewpatients">View Patients List </a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=viewProfile&&id=<%=p.getPatientId()%>">Patient Profile </a><br><br>
</div>
<div class=aside_right>
<br><br><br>
<div class=c1>
<h3></h3>

<%
int id=(Integer.parseInt(session.getAttribute("PatientDependantId").toString()));
String message=(String)request.getAttribute("message");
if(message!=null){
%>
<span style="color:red"><%=message %></span><%} %>
<table cellpadding=10>
<tr><td>Please select the relation</td>
<td>
<input type=hidden name=id value=<%=id %>>
<select name="relation" id="relation" required>
		<option></option>
		<option >Mother </option>
		<option >Father </option>
		<option>Child</option>
		<option>Spouse</option>	
	</select>
	</td></tr>
	</table>
<br>
<button type="submit" name="action" value="dependents">SUBMIT</button><br>
<%} %>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>
</form>
</center>
</body>
</html>