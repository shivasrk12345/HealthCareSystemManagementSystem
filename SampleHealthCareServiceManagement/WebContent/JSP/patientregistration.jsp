<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle1.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Patient Registration </title>

<script type="text/javascript">
function display(){	 
	if(document.frmRadio.selType[0].checked){
	document.getElementById('div1').style.display = 'block';
	document.getElementById('div2').style.display = 'none' ;
	}
	
	else if(document.frmRadio.selType[1].checked){
		document.getElementById('div1').style.display = 'none';
		document.getElementById('div2').style.display = 'block' ;
		}
}
</script>

<style>
div.c1
{
   height:700px;
   width:500px;
   background-color:grey;
   border-radius:10px;
   color:white;

}
input[type=submit] {
    background-color: #F1948A;
    color: white;
    padding: 12px 16px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
</style>
</head>
<body>
<form action="<%=request.getContextPath()%>/Controller" method="post" onsubmit="return validate();" name="frmRadio">

<div class=main>
<div class=header>
	<div class=header_left>
	<img src="CSS/logo.jpg" alt="LOGO" height="70px" width="200px">
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
<div class=aside_right><br>
<div class=c2>
<center>
<div class=c1>
<br>
<%ArrayList<Integer> list=(ArrayList<Integer>)request.getAttribute("listhcpid"); %>
<h2>Patient Registration Form</h2><br>
<table >

<tr>
<td>First Name</td>
<td><input type=text name=fname id=p1 required></td>
</tr>
<tr>
<td>Last Name</td>
<td><input type=text name=lname id=p2  required></td>
</tr>
<tr>
<td>Gender</td>
<td><input type=radio name=gender value=Male id=p3 required>Male
<input type=radio name=gender value=Female id=p4 required>Female
</td></tr>
<tr>
<td>Age</td>
<td><input type=number name=age id=p5 min=1 max=99 required></td>
</tr>
<tr>
<td>Address</td>
<td><textarea rows="5" cols="15.5" id=p6 name=address minlength=10 required></textarea>
</td></tr>
<tr><td>Contact Number</td>
<td><input type=tel name=number id=p7 maxlength=10 pattern=[0-9]{10} required></td></tr>
<tr>
<td>Medical Complaint</td>
<td><textarea rows="5" cols="15.5" id=p8 name=medical minlength=10 required></textarea>
</td></tr>
<tr><td>Referred/Consulted Doctor</td>
<td><input type=text name=doctor id=p9 required></td></tr>
<tr><td>Insurance Cover</td>
<td><input type=radio name="selType" onclick='display()' value="Yes" required>Yes</td>
<td><input type="radio" required name="selType" value="No" onclick='display()' />No</td></tr>
<tr><td><div id="div1" style="display: none">
 Health Insurance Number:<input type="text" name="health" id="txtInsuNumber" />
</div></td></tr>
<tr><td><div id="div2" style="display: none"></div></td></tr>
<tr><td>HCP ID</td><td><select name="hcpId" required>
<option></option>
<%for(Integer i:list) {%>

<option ><%=i %></option>
<%} %>
</select></td></tr>

<tr><td>Security Question</td>
<td>
<select name="security1" required>
<option></option>
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
<option></option>
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
<tr>
<td><td><input type=submit name=action value=PatientRegistration></td></tr>
</table>
</div>

</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</center>
</div>
</form>
</body>
</html>