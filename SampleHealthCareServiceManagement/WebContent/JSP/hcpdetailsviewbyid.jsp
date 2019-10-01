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

div.c2
{
   height:150px;
   width:400px;
    background-color:#D5F5E3; 
   border-radius:10px;
   color:black;
   align:center;
   background-color: linear-gradient(to right, rgba(255,0,0,0), rgba(255,0,0,1));
} 
</style>
<script>
function validateForm()
{
	var id=document.getElementById("id").value;
	if(id==""||id.length<1||isNaN(id)||id<=0)
	{
		alert("enter valid id");
		return false;
	}
	else
	{
		alert("details entered correctly");
		return true;
	}
}
</script>
</head>
<body>
<form action="<%= request.getContextPath()%>/Controller" method="post" onsubmit="return validateForm();">
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
<div class=aside_right>
<br><br><br>
<div class=c2>
<br>
<%String message=(String)request.getAttribute("message"); 
HCP h=(HCP)session.getAttribute("HCP");

if(message!=null && h!=null)
{%>
<span style="color:red;font-size:18px"><%=message %></span><br>
<%} %>
<% if(h!=null){%>
<table align=center>

<tr><td>HCP ID:</td><td><input type=text name=id id=id value="<%=h.getHcpID()%>" readonly required></td>
<td><button type=submit name=action value=viewbyid>Submit</button></td>
</tr>


</table>

<%} %>


</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div></div>
</div>

</center>
</form>
</body>
</html>