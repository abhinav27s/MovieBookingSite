<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
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
<h2>Add Movies</h2> 
<% String s=(String)request.getAttribute("addmovie");
   if(s!=null)
   { %>Movie <%= s %> Added Successfully!!<% } %>
 <% String msg=(String)request.getAttribute("msg");
   if(msg!=null)
   { %>Movie Already Added!!<% } %>
<form method ="post" enctype="multipart/form-data" action="http://localhost:8089/NiitProject/AddMovie">
<p>Enter Movie Name<input type="text" required name="moviename"></p>
<p>Enter Date of Release<input type="date" required value="2016-01-01" name="release" /> (yyyy-mm-dd)  </p>
<p>Duration of movie<input type="time" required name="time" value="00:00" />  (hrs:min)</p>
<p>Enter Movie Introduction<br>
   <textarea name="intro" rows="10" cols="30" required ></textarea>
  </p>
<p>Enter Cast of Movie<br>
   <textarea name="cast" rows="5" cols="20" ></textarea>
  </p>  
<p>Select Movie Poster Pictures<input type="file"  name="poster"></p>

<p><button type="submit">Add</button></p>
</form>
  
   
   