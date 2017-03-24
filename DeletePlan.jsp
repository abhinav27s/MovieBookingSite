<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.sql.*" %>
    <%@page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Plan Layout Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/ViewPlan.jsp">View Plan Layout</a></li>
  <li><a  href="http://localhost:8089/NiitProject/planlayout.jsp">Add Plan</a></li>
  <li><a  href="http://localhost:8089/NiitProject/DeletePlan.jsp">Delete Plan</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>Delete Plan</h2>
<%
String x=(String)request.getAttribute("delete");
if(x!=null)
{ %>Plan deleted Successfully<% } %>
<form method="get" action="http://localhost:8089/NiitProject/#DeletePlan">
Select the Plan Code to be deleted
<%@ include file="ListPlans.jsp"  %>
<button type="submit">Delete Plan</button>
</form>
</body>
</html>