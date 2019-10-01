<%@page import="com.tcs.bean.Dependant"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<Dependant> dlist=(ArrayList<Dependant>)request.getAttribute("dependantlist");
if(msg!=null&&dlist!=null)
{

%>
<span style="color:blue"><%=msg %></span>
 <%} %>
 <table>
<%for(Dependant d:dlist)
{%>
<tr><td><%=d.getName()%></td></tr>
<tr><td><%=d.getRelationship()%></td></tr>
<tr><td><%=d.getAddress()%></td></tr>
<tr><td><%=d.getContactNumber()%></td></tr>

<% }%>

</table>
</center>

</body>
</html>