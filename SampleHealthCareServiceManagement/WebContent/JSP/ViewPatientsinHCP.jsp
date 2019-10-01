<%@page import="com.tcs.bean.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tcs.bean.HCP"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%-- <%@include file="Mystyle.css" %>  --%>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> HCP Details</title>
<script>
function validateForm()
{
	var name=document.getElementById("name").value;
	var pass=document.getElementById("pass").value;
	if(name=="")
		{
			alert("enter name");
			return false;
		}
	else if(pass=="")
	{
		alert("enter password");
		return false;
	}
	else
		{
		return true;
		}
}
</script>
<style>
.aside_right1
{
	width:85.3%;
	height:450px;
	overflow:hidden;
	
	border-bottom:1px solid black;
	margin-left :auto;
	margin-right :auto;
	background-color:#D7BDE2  ;
	
}
input[type=text], input[type=password] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
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
<form method="post" action="/Controller" onsubmit="return validateForm();">
<div class=main>
<div class=header>
	<div class=header_left>
	<img src="CSS/logo.jpg" alt="LOGO" height="100px" width="200px">
	</div>
		<%HCP h=(HCP)session.getAttribute("HCP"); %>
	<div class=header_right>Patient And Health Care Service Management
	
	
	<p align="right" style="font-size:20px;font-style: italic;">WELCOME  <%=h.getHcpName()%></p><br>
	
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
<div class=aside_right1>
<%

String message=(String)request.getAttribute("message");
ArrayList<Patient> plist =(ArrayList<Patient>)request.getAttribute("Plist");
if(message!=null&&plist!=null){
%>

<span style="color:green"><%=message %></span>
<table border=1 cellpadding=10>



<tr>
<th>HCP ID</th>
<th>PatientId</th>
<th>First Name</th>
<th>Address</th>
<th>Mobile Number</th>
<th>Update</th>
<th>Delete</th>
</tr>
<%for(Patient p:plist){ %>
<tr>
<td><%=p.getHcpId() %></td>
<td><%=p.getPatientId() %></td>
<td><%=p.getFirstName() %></td>
<td><%=p.getAddress() %></td>
<td><%=p.getContactNumber() %></td>
<td><a href="<%= request.getContextPath()%>/Controller?action=updatepatientbyhcp&&id=<%=p.getPatientId()%>">Update</a></td>
<td><a href="<%= request.getContextPath()%>/Controller?action=deletepatientbyhcp&&id=<%=p.getPatientId()%>">Delete</a></td>
</tr>

<%}} %>
</table>

</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div></div>
</div>

</form>

</center>
</body>
</html>