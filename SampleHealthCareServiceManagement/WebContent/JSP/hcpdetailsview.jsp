<%@page import="java.util.ArrayList"%>
<%@page import="com.tcs.bean.HCP"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All details of HCP</title>
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
	background-color:#BDC3C7  ;
	
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
<a href="<%= request.getContextPath()%>/Controller?action=patienthcpregistration">Add Patient</a><br><br>
</div>
<div class=aside_right1>
<br>

<%
ArrayList<HCP> hcplist=(ArrayList<HCP>)request.getAttribute("HCP"); 
String message=(String)request.getAttribute("message");
if(message!=null)
{%>

<span style="color:navy;font-size:25px;align:center;font-style:italic"><%=message %></span><br>
<%} %>
<br>
<table align=center border=1 cellpadding=10>
<tr><th>HCP ID</th><th>HCP Name</th><th>License Number</th><th>Address</th><th>Contact Number</th><th>Alernate Contactnumber</th>
<th>Email</th></tr>
<%for(HCP h:hcplist){ %>


<tr>
<td><%=h.getHcpID() %></td>
<td><%=h.getHcpName() %></td>
<td><%=h.getLicenseNumber() %></td>
<td><%=h.getAddress() %></td>
<td><%=h.getContactNumber() %></td><td><%=h.getAlernateContactnumber() %></td>
<td><%=h.getEmail() %></td>

</tr>
<%} %>
</table>
</div>
</div>

<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div></div>
</div>

</center>
</body>
</html>