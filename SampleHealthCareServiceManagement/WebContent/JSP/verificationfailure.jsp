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
String msg=(String)request.getAttribute("msg");


if(msg!=null)
{
%>
<P><%=msg %><a href="<%=request.getContextPath()%>/JSP/forgot1.jsp">try again</a></P>


<%} %>

</body>
</html>