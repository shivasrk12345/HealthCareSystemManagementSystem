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
int id=Integer.parseInt(request.getAttribute("id").toString());

%>
<form method=post action="<%= request.getContextPath()%>/Controller">
<input type=hidden name=id value=<%=id%>>
<input type=submit  name=action value=GetPatientPassword>
</form>
</body>
</html>