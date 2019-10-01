<%@page import="java.util.ArrayList"%>
<%@page import="com.tcs.bean.Test"%>
<%@page import="com.tcs.bean.LSP"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <!DOCTYPE html>
    
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Mystyle.css">
<script language='javascript'>
function display(){	 
if(document.frmRadio.selType[0].checked){
document.getElementById('div1').style.display = 'block';
document.getElementById('div2').style.display = 'none' ;
document.getElementById('div3').style.display = 'none' ;

}
else if(document.frmRadio.selType[1].checked){
	document.getElementById('div1').style.display = 'none';
	document.getElementById('div2').style.display = 'block' ;
	document.getElementById('div3').style.display = 'none' ;

	}
else if(document.frmRadio.selType[2].checked){
	document.getElementById('div1').style.display = 'none';
	document.getElementById('div2').style.display = 'none' ;
	document.getElementById('div3').style.display = 'block' ;
	}
}
</script>
<style>
div.c1
{
   height:150px;
   width:400px;
   background-color:lightpink;
   border-radius:10px;
   color::#0B5345;
   align:center;
} 
</style>
</head>
<body>
<form name='frmRadio' action="<%=request.getContextPath() %>/Controller" method="post">
<%ArrayList<String> lsp1=(ArrayList<String>)request.getAttribute("list1"); %>
<%ArrayList<String> lsp2=(ArrayList<String>)request.getAttribute("list2"); %>
<%ArrayList<String> lsp3=(ArrayList<String>)request.getAttribute("list3"); %>
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
<table>
<tr><td><input type=radio name='selType' onclick='display()' value="Search by city">Search by city</td>
<td><div id='div1' style=display:none>

<select name='selOption1'>
<option>Search by city</option>
<%for(int i=0;i<lsp1.size();i++) {%>
  <option><%=lsp1.get(i)%></option>
 <%} %>
</select>
</div></td>
</tr>


<tr><td><input type=radio name='selType' onclick='display()' value="search by Test name"> search by Test name</td>
<td><div id='div2' style=display:none>
<select name='selOption2'>
<option>search by Test name</option>
<%for(int i=0;i<lsp2.size();i++) {%>
  <option> <%=lsp2.get(i)%></option>
 <%} %>
</select>
</div>
</tr>

<tr><td><input type=radio name='selType' onclick='display()' value="Search by LSP name"> Search by LSP name</td>
<td><div id='div3' style=display:none>
<select name='selOption3'>
<option>Search by LSP name</option>
<%for(int i=0;i<lsp3.size();i++) {%>
  <option><%=lsp3.get(i)%></option>
 <%} %>
</select>
</div>
</tr>
<tr height='30'><td>&nbsp;</td></tr>
<tr><td><input type="submit" value="search1" name="action"></td></tr>
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