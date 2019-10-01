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
int id=Integer.parseInt(session.getAttribute("PatientDependantId").toString());

%>
<form method=post action="<%=request.getContextPath()%>/Controller">

<table >

<tr>
<td> Name</td>
<td><input type=text name=name id=p1></td>
</tr>
<tr>
<td> relationship</td>
<td><input type=checkbox name=relationship value=spouse>Spouse</td>
<td><input type=checkbox name=relationship value=child>Child</td>
<td><input type=checkbox name=relationship value=parents>Parents</td>
</tr>

<tr>
<td>Gender</td>
<td><input type=radio name=gender value=Male id=p2>Male
<input type=radio name=gender value=Female id=p2>Female
</td></tr>
<tr>
<td>Age</td>
<td><input type=text name=age id=p3></td>
</tr>
<tr>
<td>Address</td>
<td><textarea rows="5" cols="15.5" id=p4 name=address></textarea>
</td></tr>
<tr><td>Contact Number</td>
<td><input type=text name=contactNumber id=p5></td></tr>

<tr><td>Health Insurance Cover</td>
<td><input type=checkbox name=insuranceCover   value=Yes id=p6>Yes</td>
<td><input type=checkbox name=insuranceCover  value=No id=p6>No</td>
</tr>

<tr><td>Health Insurance Number</td>
<td><input type=text name=healthInsuranceNumber id=p6></td></tr>

<tr><input type=hidden name=id value=<%=id %> ></tr>
<tr>
<td><td><input type=submit name=action value=spouseRegistration></td></tr>
<tr>
<td><td><input type=submit name=action value=childRegistration></td></tr>
<tr>
<td><td><input type=submit name=action value=parentsRegistration></td></tr>
</table>
</form>
</body>
</html>