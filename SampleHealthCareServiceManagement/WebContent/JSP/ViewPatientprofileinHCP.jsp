<%@page import="com.tcs.bean.Patient"%>
<%@page import="com.tcs.bean.HCP"%>
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
   height:400px;
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
<a href="<%= request.getContextPath()%>/Controller?action=viewhcp">View HCP Profile</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=viewhcpbyid">View HCP Profile By ID</a><br><br>

</div>
<div class=aside_right>
<br>
<div class=c1>
<%Patient p=(Patient)request.getAttribute("Pat");
String message=(String)request.getAttribute("message");
if(message!=null &&p!=null)
{%>
<span style="color:green"><%=message %></span>
<%} %>

<h3>DETAILS OF SELECTED PATIENT</h3>
<table >
<tr><th>Patient id</th><td><input type=text name=id value=<%=p.getPatientId() %> readonly></td></tr>
<tr><th>First name</th><td><input type=text name=name value=<%=p.getFirstName() %> ></td></tr>

<td>Address</td>
<td><textarea rows="5" cols="15.5" id=p6 name=address><%=p.getAddress() %></textarea>
</td></tr>
<tr><th>ContactNumber</th><td><input type=text name=number value=<%=p.getContactNumber()%>></td></tr>



</table>
<button type=submit name=action value=uphcppat>Update</button>

</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>
</form>
</center>
</body>
</html>