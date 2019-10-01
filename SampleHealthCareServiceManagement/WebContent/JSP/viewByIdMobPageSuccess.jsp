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
	<img src="CSS/logo.jpg" alt="LOGO" height="100px" width="200px">
	</div>
	<%Patient p1=(Patient)session.getAttribute("Patient"); %>
	<div class=header_right>Patient And Health Care Service Management
	<%if(session.getAttribute("username").equals(p1.getFirstName())) {
	%> 
	<p align="right" style="font-size:20px;font-style: italic;">WELCOME  <%=p1.getFirstName() %> <%=p1.getLastName() %></p><br>
	
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
<%

Patient p=(Patient)session.getAttribute("patient");
if(p!=null)
{
%>

<div class=aside_left>
<li><a href="<%= request.getContextPath()%>/Controller?action=viewpatients">View Patients List </a></li><br><br>
<li><a href="<%= request.getContextPath()%>/Controller?action=viewProfile&&id=<%=p.getPatientId()%>">Patient Profile </a></li><br><br>
<li><a href="<%=request.getContextPath()%>/Controller?action=addDependant&&id=<%=p.getPatientId()%>">ADD Dependant</a></li><br><br>
<li><a href="<%= request.getContextPath()%>/Controller?action=changepwdpatient&&id=<%=p.getPatientId()%>">Change Password?</a></li><br><br>
<li><a href="<%= request.getContextPath()%>/Controller?action=viewdependantsById&&id=<%=p.getPatientId()%>">view dependants</a></li><br><br>
<li><a href="<%= request.getContextPath()%>/Controller?action=updateDependantById&&id=<%=p.getPatientId()%>">update dependant</a></li><br><br>
<li><a href="<%= request.getContextPath()%>/Controller?action=deleteDependantsById&&id=<%=p.getPatientId()%>">delete dependant</a></li><br><br>
</div>
<div class=aside_right>
<br>
<div class=c1>
<h3>DETAILS OF SELECTED PATIENT</h3>
<table >
<tr><th>Patient id</th><td><input type=text name=id value=<%=p.getPatientId() %> readonly></td></tr>
<tr><th>first name</th><td><input type=text name=fname value=<%=p.getFirstName() %> ></td></tr>
<tr><th>last name</th><td><input type=text name=lname value=<%=p.getLastName() %>></td></tr>
<tr>
<td>Gender:</td>
<td><input type=radio name=gender id=a2 value=Male <%if(p.getGender().equals("Male")){%> checked="checked"<%} %> >Male
<input type=radio name=gender id=a2 value=Female <%if(p.getGender().equals("Female")){%> checked="checked"<%} %>>Female</td><tr><th>Age</th><td><input type=text name=age value=<%=p.getAge() %>></td></tr>
<tr>
<td>Address</td>
<td><textarea rows="5" cols="15.5" id=p6 name=address><%=p.getAddress() %></textarea>
</td></tr>
<tr><th>ContactNumber</th><td><input type=text name=contactNumber value=<%=p.getContactNumber()%>></td></tr>
<tr><th>HealthInsuranceNumber</th><td><input type=text name=healthInsuranceNumber value=<%=p.getHealthInsuranceNumber() %>></td></tr>

<tr><td><a href="<%=request.getContextPath()%>/Controller?action=update&&id=<%=p.getPatientId()%>">Update</a></td></tr>
<tr><td><a href="<%=request.getContextPath()%>/Controller?action=delete&&id=<%=p.getPatientId()%>">Delete</a></td></tr>

<%} }%>
</table>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>
</form>
</center>
</body>
</html>