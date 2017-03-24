<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
 <%
 String id=(String)request.getAttribute("id");
 %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/backfinal.jpg">
<center>
<h1>
Seats Booked Successfully !!
</h1><br><br>
<h2>
Your booking id is CCN<%= id%>
</h2>
<h3>
A confirmation mail has been sent to your registered mail id.<br>
See you right in the theater..!!!
Have a great time ;D
</h3>
</center>
</body>
</html>