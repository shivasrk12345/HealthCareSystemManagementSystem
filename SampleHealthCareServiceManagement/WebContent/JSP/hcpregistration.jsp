<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> HCP Registration </title>
<!-- <script>
function validate()
{
	var name=document.getElementById("name").value;
	var licence=document.getElementById("licnum").value;
	var address=document.getElementById("address").value;
	var number=document.getElementById("number").value;
	var pattern=/^[7|8|9]{1}[0-9]{9}$/;
	var alternate=document.getElementById("alternate").value;
	var email=document.getElementById("email").value;
	
	var e1 = document.getElementById("ques1"); 
	var q1 = document.getElementById("ques1").value; 
    var strUser1 = e1.options[e1.selectedIndex].text; 
	var ans1=document.getElementById("ans1").value;
	var e2 = document.getElementById("ques2");  
	var q2 = document.getElementById("ques2").value;
    var strUser2 = e2.options[e2.selectedIndex].text; 
    var ans2=document.getElementById("ans2").value;
	 if(name=="" || name.length<3)
		{
		  alert("Enter valid  Name ");
		  return false;
		  
		}
	 else if(licence=="" || licence.length<3)
		{
		  alert("Enter valid Licence number ");
		  return false;
		  
		}
	 else if(address=="" || address.length<10)
		{
		  alert("Enter valid Address ");
		  return false;
		  
		}
	 else if(number=="" || number.length!=10 || isNaN(number) || pattern.test(number)==false)
		{
		  alert("Enter valid Contactnumber ");
		  return false;
		  
		}
	 else if(alternate=="" || alternate.length!=10 || number==alternate || isNaN(alternate) || pattern.test(alternate)==false)
		{
		  alert("Enter valid Alternate Contactnumber ");
		  return false;
		  
		}
	 else if(email=="" || email.length<10 || email.indexOf("@")<1 || email.lastIndexOf(".")<email.indexOf("@")+2 || email.lastIndexOf(".")+2>=email.length) 
		{
		  alert("Enter valid e-mail ");
		  return false;
		  
		}
	 if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
	        alert("Not a valid e-mail address");
	        return false;
	    }
	 else if (strUser1 == "---Select question---") //for text use if(strUser1=="Select")  
	    {  
	        alert("Please select security question");  
	        return false;  
	    }  
	 else if(ans1=="" || ans1.length<3)
		{
		  alert("Enter valid  Answer ");
		  return false;
		  
		}
	 else  if (strUser2 == "---Select question---") //for text use if(strUser1=="Select")  
	    {  
	        alert("Please select another security question ");  
	        return false;  
	    }  
	 else  if (q1 == q2) //for text use if(strUser1=="Select")  
	    {  
	        alert("Please select different security question");  
	        return false;  
	    }  
	 else if(ans2=="" || ans2.length<3)
		{
		  alert("Enter valid  Answer ");
		  return false;
		  
		}
	 else
		 {
		 alert("Details entered correct1y");
		 return true;
		 }

	
	
	}

</script> -->
<style>
div.c2
{
   height:425px;
   width:500px;
   background-color:grey;
   border-radius:10px;
   color:white;
   align:center;
   pstition:fixed;
} 
button {
    background-color: #F1948A;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}
</style>
</head>
<body>
<form action="<%=request.getContextPath()%>/Controller" method="post" onsubmit="return validate();">
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
<div class=c2>
<h2>Health Care Provider Registration</h2>
<table align=center>
<tr><td>Health Care Provider name:</td><td><input type="text" name="name" id="name" required></td></tr>
<tr><td>License number:</td><td><input type="text" name="licensenum" id="licnum" required></td></tr>
<tr><td>Address:</td><td><textarea rows="5" cols="21" name="address" id="address" minlength=10 ></textarea></td></tr>
<tr><td>Contact number:</td><td><input type="text" name="contactnum" id="number" maxlength=10 pattern=[0-9]{10} required></td></tr>
<tr><td>Alternate Contact number:</td><td><input type="text" name="alternatecontact" id="alternate" maxlength=10 pattern=[0-9]{10} required></td></tr>
<tr><td>Email ID:</td><td><input type="text" name="email" id="email" ></td></tr>
<tr><td>Security Questions: </td><td><select name="ques1" id="ques1" required>
		<option>-------Select question-------</option>
		<option>Your BirthCity</option>
		<option>Your Favourite Color</option>
		<option>Your Favourite food</option>	
	</select>
</td><tr>
<tr><td>Answer:</td><td><input type="text" name="ans1" id="ans1" required></td></tr>
<tr><td>Security Questions: </td><td><select name="ques2" id="ques2" required>
		<option>-------Select question-------</option>
		<option>Your BirthCity</option>
		<option>Your Favourite Color</option>
		<option>Your Favourite food</option>	
	</select>
</td><tr>
<tr><td>Answer:</td><td><input type="text" name="ans2"  id="ans2" required></td></tr>
<tr><td></td><td><button type="submit" name="action" value="RegisterHCP" >Register</button></td></tr>
</table>
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div></div>
</div>

</center>
</form>
</body>
</html>