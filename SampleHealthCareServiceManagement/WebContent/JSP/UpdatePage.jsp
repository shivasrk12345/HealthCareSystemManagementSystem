<%@page import="com.tcs.bean.Patient"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW</title>
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
<form method=post action="<%=request.getContextPath()%>/Controller">

<div class=main>
<div class=header>
	<div class=header_left>
	<img src="logo.png" alt="LOGO" height="70px" width="100px">
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
<div class=aside_right>
<br><br><br>
<div class=c1>
<%
String msg=(String)request.getAttribute("msg");
Patient p=(Patient)request.getAttribute("patient");
if(msg!=null&&p!=null)
{
%>
<table >
<tr><th>Patient id</th><td><input type=text name=id value=<%=p.getPatientId() %> readonly></td></tr>
<tr><th>first name</th><td><input type=text name=fname value=<%=p.getFirstName() %> ></td></tr>
<tr><th>last name</th><td><input type=text name=lname value=<%=p.getLastName() %>></td></tr>
<tr><th>Gender</th><td><input type=text name=gender value=<%=p.getGender() %>></td></tr>
<tr><th>Age</th><td><input type=text name=age value=<%=p.getAge() %>></td></tr>
<tr><th>Address</th><td><input type=text name=address value=<%=p.getAddress() %>></td></tr>
<tr><th>ContactNumber</th><td><input type=text name=contactNumber value=<%=p.getContactNumber()%>></td></tr>
<tr><th>HealthInsuranceNumber</th><td><input type=text name=healthInsuranceNumber value=<%=p.getHealthInsuranceNumber() %>></td></tr>

<tr><th>Update The Details</th></tr>
<%} %>
</table>
<button type=submit name=action value=updating>Update</button>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>
</form>
</center>
</body>
</html>