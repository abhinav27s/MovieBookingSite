<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Sites Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/ListSite.jsp">View Sites</a></li>
  <li><a href="http://localhost:8089/NiitProject/AddSite.jsp">Add Site</a></li>
  <li><a href="http://localhost:8089/NiitProject/Edit.jsp">Edit Site</a></li>
  <li><a href="http://localhost:8089/NiitProject/Delete.jsp">Delete Site</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>Add Site</h2>
<form method ="get" action="http://localhost:8089/NiitProject/AddSite">
Enter Site Details 
<p> Site Location<input type="text" name="sitename"></p>
<!--  <p> Site Code<input type="number" name="sitecode"></p> -->
<button type="submit">Add</button>
</form>
<% 
String x=(String)request.getAttribute("addsite");
if(x!=null)
{%><p>Site Successfully Added!</p><%} %>

<% 
String y=(String)request.getAttribute("msg");
if(y!=null)
{%><p>Site Location already registered!</p><%} %>
</body>
</html>