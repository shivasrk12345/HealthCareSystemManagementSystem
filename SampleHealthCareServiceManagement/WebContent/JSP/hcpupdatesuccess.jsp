<%@page import="com.tcs.bean.HCP"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Success</title>
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
	<div class=header_right>Patient And Health Care Service Management
	<p align="right" style="font-size:20px;font-style: italic;">WELCOME  <%=session.getAttribute("username")%></p><br>
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
<a href="<%= request.getContextPath()%>/Controller?action=viewhcp">View HCP Profile</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=viewhcpbyid">View HCP Profile By ID</a><br><br>
</div>
<div class=aside_right>
<br><br><br>
<div class=c1>
<%HCP h=(HCP) request.getAttribute("HCP");
String message=(String)request.getAttribute("message");
if(message!=null)
{%>
<span style="color:green;font-size:25px"><%=message %></span>
<%} %>
<table align=center>
<tr><td>HCP id:</td><td><%=h.getHcpID() %></td></tr>
<tr><td>HCP Name:</td><td><%=h.getHcpName() %></td></tr>
<tr><td>Address:</td><td><%=h.getAddress() %></td></tr>
<tr><td>Contact number:</td><td><%=h.getContactNumber() %></td></tr>
<tr><td>Alternate Contact number:</td><td><%=h.getAlernateContactnumber() %></td></tr>
<tr><td>Email:</td><td><%=h.getEmail() %></td></tr>
</table>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div></div>
</div>

</center>
</body>
</html>