<%@page import="java.util.ArrayList"%>
<%@page import="com.tcs.bean.Test"%>
<%@page import="com.tcs.bean.LSP"%>
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
background-color:lightyellow;
color:black;
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
<form  action="<%=request.getContextPath() %>/Controller" method="post">
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
   
  
  
</ul>
</div>
<div class=aside>
<div class=aside_left>
<a href="<%= request.getContextPath()%>/Controller?action=patient">Patient</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=hcp">Health Care Provider</a>
</div>
<div class=aside_right1>
<br>

<%ArrayList<LSP> hc=(ArrayList<LSP>)request.getAttribute("list1"); %>
<table border='1' cellpadding=10>

<tr><th>Lab Service Provider Name</th>
<th>Address</th>
<th>Zipcode</th>
<th>State</th>
<th>City</th>
<th>Test Name</th>
<th>Test Code</th>
<th>Test Description</th>
<th>Cost of the Test</th>
<th>Lab@Home</th>
<th>View Schedule</th></tr>

<%for(LSP l:hc){ %>	

<%for(Test h:l.getTest()){ %>
<%if(l.getLabId()==h.getLabId()) {%>
<tr>
<td><%=l.getLSPName()%></td>
	<td><%=l.getAddress()%></td>
	<td><%=l.getZipcode()%></td>
	<td><%=l.getState()%></td>
	<td><%=l.getCity()%></td>
	<td><%=h.getTestName()%></td>
	<td><%=h.getTestCode()%></td>
	<td><%=h.getTestDesc()%></td>
	<td><%=h.getCost()%></td>
	<td><%=h.getLabAtHome()%></td>
	<td><a href="Controller?action=viewall&&labid=<%=h.getLabId()%>">View</a>
</tr>
<%} %>
<%} %>
<%} %>
</table>
</div>
</div>

<div class=footer><h5 style="color:blue">copyright@2017 resrved</h5></div>
</div>

</center>
</form>
</body>
</html>