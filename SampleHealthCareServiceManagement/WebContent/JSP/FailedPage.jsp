<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String RegistrationMessage=(String)request.getAttribute("RegistrationMessage");
String ViewpatientsMessage=(String)request.getAttribute("ViewpatientsMessage");
 String ViewFailedMessage=(String)request.getAttribute("ViewFailedMessage");
 
%>
<%if(ViewpatientsMessage!=null)
	{
	%>
	<span style="color:red"><%=ViewpatientsMessage %></span>
	<%} %>
	
	
	<%if(ViewFailedMessage!=null)
	{
	%>
	<span style="color:red"><%=ViewFailedMessage %></span>
	<%} %>
	
	
	

</body>
</html>