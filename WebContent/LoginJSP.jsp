<%@page import="com.d.Dbutil"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.lang.ClassNotFoundException" %>
<%@ page import="java.sql.ResultSet" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome to Bridgelabz</title>
<script>

</script>
</head>
<body bgcolor="cyan">
<center>
<% 
String msg =(String)request.getParameter("error");
if(msg==null)
{
 msg=(String)request.getAttribute("error");	
if(msg==null)
	msg="";

} 
%>
<%=msg %>
</center>
<!-- if(msg==null)
{
 msg=(String)request.getAttribute("error");	
if(msg==null)
	msg="";

} -->
<center>LOGIN</center>
<fieldset>
		<legend>Login</legend>
		<form action="login" method="post">
			<br>
			<br>
			<table align="center">
				<tr>
					<th>Username</th>
					<th><input type="text" name="uname"
						placeholder="Enter Your Username " required><br></th>
				</tr>
				<tr>
					<th>Password:</th>
					<th><input type="password" name="pass"
						placeholder="Enter your Password" required><br></th>
				</tr>
			</table>
			<center><button type="submit">Submit</button></center>
		</form>
	</fieldset>
<br><br>
  

</center>
</div>
</body>
</html>