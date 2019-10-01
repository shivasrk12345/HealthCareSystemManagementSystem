<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<%-- <%@include file="Mystyle.css" %>  --%>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Patient Login</title>
<!-- <script>
function validateForm()
{
	var name=document.getElementById("name").value;
	var password=document.getElementById("pass").value;
	if(name==""||name.length<2)
		{
			alert("enter name");
			return false;
		}
	else if(password==""||password.length<4)
	{
		alert("enter password");
		return false;
	}
	else
		{
		return true;
		}
}
</script> -->
<style>

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
<form method="post" action="<%=request.getContextPath()%>/Controller" onsubmit="return validateForm();">
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
<div class=aside_right>
<br><br>
<div class=c1>
<%String message=(String)request.getAttribute("message");
if(message!=null){%>
<span style="color:red"><%=message %></span>
<%} %>
<br><h2>Patient Login</h2>

Patient ID<br>
<input type="text" name="username" id="name"  maxlength="10" required><br>
Password<br>
<input type=password name="password" id="pass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required><br>
<button type="submit" name="action" value="patientdetails">Login</button><br>

<a href="<%= request.getContextPath()%>/Controller?action=signuppatient">SIGNUP</a><br>
<a href="<%= request.getContextPath()%>/Controller?action=forgotpwdpatient">Forgot Password?</a>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>

</form>

</center>
</body>
</html>