<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
</head>
<style>
.aside_right1
{
	width:85.3%;
	height:450px;
	overflow:hidden;
	
	border-bottom:1px solid black;
	margin-left :auto;
	margin-right :auto;
	background-color:#D7BDE2  ;
	
}</style>
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
<li><a></a></li>
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

<!-- <img class="images" src="wel.jpg" alt="sales" height="300px" width="800px"> -->
<center>
<div class="mySlides"><img class="images" src="CSS/home1.jpg" alt="image1" height="450px" width="100%"></div>
<div class="mySlides"><img class="images" src="CSS/home2.jpg" alt="image2" height="450px" width="100%"></div>

<div class="mySlides"><img class="images" src="CSS/home4.jpg" alt="image4" height="450px" width="100%"></div>
<div class="mySlides"><img class="images" src="CSS/home5.jpg" alt="image5" height="450px" width="100%"></div>
<div class="mySlides"><img class="images" src="CSS/home6.jpg" alt="image6" height="450px" width="100%"></div>
<div class="mySlides"><img class="images" src="CSS/home7.jpg" alt="image7" height="450px" width="100%"></div>


</center>
</div>

</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div></div>
</div>
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1;}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
</center>

</body>
</html>
