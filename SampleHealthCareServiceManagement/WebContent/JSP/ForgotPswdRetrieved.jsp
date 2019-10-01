<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Success</title>
<style>

div.c1
{
   height:150px;
   width:400px;
   background-color:lightpink;
   border-radius:10px;
   color::#0B5345;
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
<a href="<%= request.getContextPath()%>/Controller?action=patient">Patient</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=hcp">Health Care Provider</a>
</div>
<div class=aside_right>
<br><br><br>
<div class=c1>
<br><br>
<span font-size:20px>
<center>
<%
String msg=(String)request.getAttribute("msg");
int id=Integer.parseInt(request.getAttribute("id").toString());
String pswd=(String)request.getAttribute("password");
if(msg!=null&&id!=0&&pswd!=null)
{
%>
<%=msg %>
<%=id %>
<%=pswd %>
<%} %>
</center>
</span>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>

</center>
</body>
</html>