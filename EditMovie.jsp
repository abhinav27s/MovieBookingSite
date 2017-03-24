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
<h1>Movies Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/movies.jsp">View Movies</a></li>
  <li><a href="http://localhost:8089/NiitProject/AddMovie.jsp">Add Movie</a></li>
  <li><a href="http://localhost:8089/NiitProject/EditMovie.jsp">Edit Movie</a></li>
  <li><a href="http://localhost:8089/NiitProject/DeleteMovie.jsp">Delete Movie</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>Edit Movies</h2> 
<form method="get" action="http://localhost:8089/NiitProject/MovieDetails.jsp">
<p> Select a Movie
<%@ include file="MoviesView.jsp"  %>
</p>
<p><button type="submit">Edit</button></p>
</form><br>
<% String movie=(String)request.getAttribute("edit");
   if(movie!=null)
   {%>Movie <%= movie %> Edited Successfully !<%} %>
</body>
</html>