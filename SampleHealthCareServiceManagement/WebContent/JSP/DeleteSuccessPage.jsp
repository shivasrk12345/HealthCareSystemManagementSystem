<%@page import="com.tcs.bean.Patient"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Success</title>
<style>

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
<br><br><br>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null)
{%>
<span style="color:red;font-size:25px"><%=msg%></span><br>
<%} %>
<%} %>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>

</center>
</body>
</html>