<%@page import="com.tcs.bean.Patient"%>
<%@page import="com.tcs.bean.HCP"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW BY ID OR MOBILE</title>
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
<div class=c2>
<br>
<%Patient p=(Patient)session.getAttribute("Patient"); %>

Id:<input type=radio name="action" value="viewById1" required><br>
mobile:<input type=radio name="action" value="ViewByMobile1" required><br>
Enter :<input type=text name=search required>
<input type=submit value=view>

</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>

</center>
</form>
</body>
</html>