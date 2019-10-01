<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<%-- <%@include file="Mystyle.css" %>  --%>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABOUT CLC</title>

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
<br>
<h3>ABOUT CLC GROUP OF LABS</h3><br>
CLC Group was started by visionary entrepreneur and philanthropist CLC Suryanarayana. 22 years later, we have proven a model that combines the best of healthcare and other businesses that contribute to the national and international market.

Since 1995's establishment of CLC Hospitals, to the start of CLC Institute of Medical Science and CLC Diagnostic Centres few years later, there emerged the concept of combining research, teaching and patient care. This was a model, that lead to a national and international reputation for excellence in total care.

Today, CLC is identified as a Future of Healthcare & one of the best medical enterprise in India. This company unites the physicians and scientists with the health professionals and facilities that make up the broad, integrated CLC Hospital's health system.
</div>
</div>
</div>
<div class=footer><h5 style="color:blue">copyright@2017 reserved</h5></div>
</div>

</form>

</center>
</body>
</html>