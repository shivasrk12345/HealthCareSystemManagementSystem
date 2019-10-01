<%@page import="com.tcs.bean.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password Page</title>
<script>
 function validateForm()
 {
	
	 var password1=document.getElementById("p1").value;
	 var password2=document.getElementById("p2").value;
	 var password3=document.getElementById("p3").value;
	
	 if(password1=="" || password2=="" || password3=="")
		 {
		 	alert("enter password");
		 	return false;
		 }
	 
	 else if(password2!=password3)
		 {
		 	alert("password mismatch");
		 return false;
		 }
	 else if(paasword2.substr()!=[a,z] || password.substr()!=[0,9] || password2.substr()!=[A,Z])
		 {
		 	alert("password doesnt satisfies the properties");
		 	return false;
		 }
	 else 
		 {
		 	return true;
		 }
	 
 }
</script>
<style>
input[type=text], input[type=password] {
    width: 100%;
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
    width: 60%;
}
</style>
</head>
<body>

<center>
<form method="post" action="<%=request.getContextPath() %>/Controller" onsubmit="return validateForm();">
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
  <li><a href="<%= request.getContextPath()%>/Controller?action=aontactus">CONTACT US</a></li>
  <li><a href="<%= request.getContextPath()%>/Controller?action=viewlsp">VIEWLSP</a></li>
  
  
</ul>
</div>
<div class=aside>
<div class=aside_left>
<a href="<%= request.getContextPath()%>/Controller?action=viewhcp">View HCP Profile</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=viewhcpbyid">View HCP Profile By ID</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=patienthcpregistration">Add Patient</a><br><br>
</div>
<div class=aside_right>
<br>
<div class=c1>
<%
int hcpid=Integer.parseInt(request.getAttribute("HCPID").toString());

String message=(String)request.getAttribute("msg");
if(message!=null){%>
<span style="color:red;font-size:20px;"><%=message %></span><%} %>
<br><h2>Change Password</h2><br>

<table>
<tr>
<td>Current Password</td>
<td><input type="password" name="password1" id="p1" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required></td>
</tr>
<tr>
<td>New Password</td>
<td><input type="password" name="password2" id="p2" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required></td>
</tr>
<tr>
<td>Confirm New Password</td>
<td><input type="password" name="password3" id="p3" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required></td>
</tr>
<tr><input type=hidden name=id value=<%=hcpid %>></tr>
</table>
<button type="submit" name="action" value="hcpchangepassword">Change Password</button>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div></div>
</form>
</center>
</body>
</html>