<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS\Mystyle.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD DEPENDENT</title>
<script>
function validate()
{
	
	var name=document.getElementById("p1").value;
	var gender=document.getElementById("p2").checked;
	var age=document.getElementById("p3").value;
	var address=document.getElementById("p4").value;
	var number=document.getElementById("p5").value;
	var healthinsurancenumber=document.getElementById("p6").value;
	
	
	
	 if(name=="" || name.length<3)
	{
	  alert("Enter valid name ");
	  return false;
	  
	}
	 
	
	 else if(gender=="" )
		{
		  alert("select gender");
		  return false;
		  
		}
	else if(age=="" || age<0)
	{
	  alert("Enter valid age");
	  return false;
	  
	}
	 else if(address=="" || address.length<10)
		{
		  alert("Enter valid address ");
		  return false;
		  
		}
	else if(number=="" || number.length<10)
	{
	  alert("Enter valid number ");
	  return false;
	  
	}
	
	else if(healthinsurancenumber=="" || healthinsurancenumber.length<3)
	{
	  alert("Enter valid health insurance number ");
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
<form method=post action=Controller onsubmit="return validate();">
<center>

<%
int id=Integer.parseInt(session.getAttribute("PatientDependantId").toString());

%>

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
<br>
<div class=c1>
<h3>Spouse</h3>
<table >

<tr>
<td> Name</td>
<td><input type=text name=name id=p1 required></td>
</tr>
<tr>
<td> Relationship</td>
<td><input type=radio name=relationship value=spouse required>Spouse</td>
<td><input type=radio  name=relationship value=child required>Child</td>
<td><input type=radio name=relationship value=parents required>Parents</td>
</tr>

<tr>
<td>Gender</td>
<td><input type=radio name=gender value=Male id=p2 required>Male
<input type=radio name=gender value=Female id=p2 required>Female
</td></tr>
<tr>
<td>Age</td>
<td><input type=text name=age id=p3 min=1 max=99 required></td>
</tr>
<tr>
<td>Address</td>
<td><textarea rows="5" cols="15.5" id=p4 name=address  minlength=10 required></textarea>
</td></tr>
<tr><td>Contact Number</td>
<td><input type=text name=contactNumber id=p5 maxlength=10 pattern=[0-9]{10} required></td></tr>

<tr><td>Health Insurance Cover</td>
<td><input type=radio name=insuranceCover   value=Yes id=p6 required>Yes</td>
<td><input type=radio name=insuranceCover  value=No id=p6 required>No</td>
</tr>

<tr><td>Health Insurance Number</td>
<td><input type=text name=healthInsuranceNumber id=p6 required></td></tr>


<tr><td><input type=hidden name=id value="<%=id %>" ></td></tr>
<tr>
<td><td><input type=submit name=action value=spouseRegistration></td></tr>
</table>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>
</center>
</form>
</body>
</html>