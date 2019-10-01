<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password Page</title>
<script>
function validateForm()
{
	var city=document.getElementById("city").value;
	var actor=document.getElementById("actor").value;
	var food=document.getElementById("food").value;
	if(city=="")
		{
		alert("enter city");
		return false;
		}
	else if(actor=="")
		{
		alert("enter actor");
		return false;
		}
	else if(food=="")
		{
		alert("enter food");
		return false;
		}
	else
		{
		return true;
		}
}
</script>
<style>
.c2{
   align : center;
   margin: 10px;
   padding: 10px;
   width: 600px;
   height: 400px;
   border: 1px solid black;
   background-color: #5D6D7E  ;
   border-radius:25px;
   color:white;
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
<%
int id=Integer.parseInt(request.getAttribute("id").toString());
%>
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

<div class=c2>
<br><h2>Forgot Password</h2><br>

Please answer the below security questions
<table>
<tr><td>Security Question</td>
<td>
<select name="security1" required>
<option value=yourbirthcity>YourBirthcity</option>
<option value="yourfavoriteactor">YourFavoriteactor</option>
<option value="yourfavoritefood">YourFavoritefood</option>
<option value="yourfavoritecrickter">YourFavoritecrickter</option>
<option value="yourfavoritesport">YourFavoritesport</option>
</select>

</td></tr>
<tr>
<td>Enter the Security Question Answer1</td>
<td><input type="text" name="securityanswer1" required></td>
</tr>
<tr><td>Security Question</td>
<td>
<select name="security2" required>
<option value=yourbirthcity>YourBirthcity</option>
<option value="yourfavoriteactor">YourFavoriteactor</option>
<option value="yourfavoritefood">YourFavoritefood</option>
<option value="yourfavoritecrickter">YourFavoritecrickter</option>
<option value="yourfavoritesport">YourFavoritesport</option>
</select>

</td></tr>
<tr>
<td>Enter the Security Question Answer2</td>
<td><input type="text" name="securityanswer2" required></td>
</tr>
<tr><input type=hidden name=id value=<%=id %>></tr>

</table>
<button type="submit" name="action" value="verifySecurityAnswers">Verify</button>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>
</form>

</center>
</body>
</html>