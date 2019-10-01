<%@page import="com.tcs.bean.HCP"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW BY ID</title>
<style>

div.c1
{
   height:370px;
   width:400px;
   background-color:lightpink;
   border-radius:10px;
   color:#154360  ;
   align:center;
} 
button {
    background-color: #F1948A;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 50%;
}
</style>
</head>
<body>
<center>
<form action="<%= request.getContextPath()%>/Controller" method=post> 

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
<%HCP h=(HCP) request.getAttribute("HCP"); %>
<div class=aside>
<div class=aside_left>
<a href="<%= request.getContextPath()%>/Controller?action=viewhcp">View HCP Profile</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=viewhcpbyid">View HCP Profile By ID</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=patienthcpregistration">Add Patient</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=hcpchangepwdpatient&&id=<%=h.getHcpID()%>">Change Password?</a>
</div>
<div class=aside_right>
<br>
<div class=c1>
<%
String message=(String)request.getAttribute("message");
if(message!=null)
{%>
<br><span style="color:green;font-size:18px"><%=message %></span><br><br>
<%} %>
<table align=center>
<tr><td>Health Care Provider ID:</td><td><input type="text" name="id" id="id" value="<%=h.getHcpID()%>" readonly></td></tr>
<tr><td>Health Care Provider Name:</td><td><input type="text" name="name" id="name" value="<%=h.getHcpName()%>"></td></tr>
<tr><td>License number:</td><td><input type="text" name="licensenum" id="licnum" value="<%=h.getLicenseNumber()%>" readonly></td></tr>
<tr><td>Address:</td><td><textarea rows="5" cols="21.5" name="address" id="address" ><%=h.getAddress()%></textarea></td></tr>
<tr><td>Contact number:</td><td><input type="text" name="contactnum" id="number" value="<%=h.getContactNumber()%>"></td></tr>
<tr><td>Alternate Contact number:</td><td><input type="text" name="alternatecontact" id="alternate" value="<%=h.getAlernateContactnumber()%>"></td></tr>
<tr><td>Email ID:</td><td><input type="text" name="email" id="email" value="<%=h.getEmail()%>"></td></tr>



</table>
<button type=submit name=action value=updatebyid>UPDATE</button>

</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>
</form>
</center>
</body>
</html>