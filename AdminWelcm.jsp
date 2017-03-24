<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<head>
<link type="text/css" rel="stylesheet" href="http://localhost:8089/NiitProject/AdminWelcm.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Admin</h1>
<h2>Choose any of the following links-</h2>
<ul class="mylist">
<p><li><a href="http://localhost:8089/NiitProject/ListSite.jsp">Sites Settings</a></li></p>
<p><li><a href="http://localhost:8089/NiitProject/Theaters.jsp"> Theater Settings</a></li></p>
<p><li><a href="http://localhost:8089/NiitProject/ViewShows.jsp">Shows Settings</a></li></p>
<p><li><a href="http://localhost:8089/NiitProject/ViewPlan.jsp">Plan Layout</a></li></p>
<p><li><a href="http://localhost:8089/NiitProject/seatmap.jsp">Seats Mapping</a></li></p>
<p><li><a href="http://localhost:8089/NiitProject/movies.jsp">Movies Settings</a></li></p>
<p><li><a href="http://localhost:8089/NiitProject/refresh.jsp">Refresh Seat Availability Status</a></li></p>
<p><li><a href="http://localhost:8089/NiitProject/snacks.jsp">Snacks Settings</a></li></p>
</ul>
<a href="Logout">
<img src="images/Logout.jpg" height="100" width="100" >
</a>
</body>
</html>