<%@page import="com.tcs.bean.Dependant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<%
String msg=(String)request.getAttribute("msg");
Dependant d=(Dependant)request.getAttribute("dep");
if(msg!=null&&d!=null)
{
%>
<span style="color:blue"><%=msg %></span>
 <%} %>
 
 <form method=post action="<%=request.getContextPath()%>/Controller">
 <table>
 <tr><td><input type=text name="id" value=<%=d.getPatientId()%>></td></tr>
<tr><td><input type=text name="name" value=<%=d.getName()%>></td></tr>
<tr><td><input type=text name=depaddress value=<%=d.getAddress()%>></td></tr>
<tr><td><input type=text name=depcontactNumber value=<%=d.getContactNumber()%>></td></tr>
<tr><td><input type=text name="HealthInsuranceNumber" value=<%=d.getHealthInsuranceNumber()%>></td></tr>
<tr><td><button type=submit name=action value=UpdateDependantByPid></button></td></tr>
</table>
</form>
</center>
</body>
</html>