<%@page import="com.d.User"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
<fieldset>
<legend>Personal Details</legend>
<form>
<table>
<% User u = (User)request.getAttribute("user"); %>


<tr><td>Username 	:<% out.println(u.getUname());%></td></tr>
<tr><td>Gender 	:<% out.println(u.getGender());%></td></tr>
<tr><td>Country 	:<% out.println(u.getCountry());%></td></tr>



</table>
</form>
</fieldset>


<br><br><center>
<form action="Logout" method="post">
		<input type="submit" value="Logout">
		</center>
	</form>
</body>
</html>



