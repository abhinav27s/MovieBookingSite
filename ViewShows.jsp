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
<h1>Shows Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/ViewShows.jsp">View Shows</a></li>
  <li><a href="http://localhost:8089/NiitProject/AddShow.jsp">Add Show</a></li>
  <li><a href="http://localhost:8089/NiitProject/EditShow.jsp">Edit Show</a></li>
  <li><a href="http://localhost:8089/NiitProject/DeleteShow.jsp">Delete Show</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>View Shows</h2>
<form method ="post" action="http://localhost:8089/NiitProject/ShowsView.jsp">
<p>Select a Movie <%@ include file="MoviesView.jsp"  %> </p>
<p>Select a Site <%@ include file="SitesView.jsp"  %>  </p>
<p><button type="submit">View</button></p>
</form> 
</body>
</html>