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
<h1>Theater Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/Theaters.jsp">View Theaters</a></li>
  <li><a  href="http://localhost:8089/NiitProject/AddTheater.jsp">Add Theaters</a></li>
  <li><a  href="http://localhost:8089/NiitProject/EditTheater.jsp">Edit Theaters</a></li> 
   <li><a  href="http://localhost:8089/NiitProject/DeleteTheater.jsp">Delete Theaters</a></li>
   <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>View Theaters</h2>
<form method="get" action="http://localhost:8089/NiitProject/ViewTheater">
<p> Select a Site
<%@ include file="SitesView.jsp"  %>
</p>
<p><button type="submit">View Theaters</button></p>
</form>

</body>
</html>