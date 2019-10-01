<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<script>
function validateForm()
{
var id=document.getElementById("id").value;
if(id=="")
	{
	 alert("enter valid id");
	 return false;
	}
else
	{
	return true;
	}
}
</script>
<style>

button {
    background-color: #F1948A;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 60%;
}
input[type=text], input[type=password] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
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
<a href="<%= request.getContextPath()%>/Controller?action=patient">Patient</a><br><br>
<a href="<%= request.getContextPath()%>/Controller?action=hcp">Health Care Provider</a>
</div>
<div class=aside_right>
<br><br>
<div class=c1>
<%String msg=(String)request.getAttribute("msg");
if(msg!=null){%>
<span style="color:red;font-size:20px;"><%=msg %></span>
<%} %>
<br><h2>Forgot Password</h2><br>

Your ID:<input type="text" name="id" id="id" required><br>
<button type="submit" name="action" value="verifybyhcpid">Verify</button>

</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div></div>
</div>
</form>
</center>
</body>
</html>