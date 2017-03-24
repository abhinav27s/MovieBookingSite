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
<h1>Shows Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/ViewShows.jsp">View Shows</a></li>
  <li><a href="http://localhost:8089/NiitProject/AddShow.jsp">Add Show</a></li>
  <li><a href="http://localhost:8089/NiitProject/EditShow.jsp">Edit Show</a></li>
  <li><a href="http://localhost:8089/NiitProject/DeleteShow.jsp">Delete Show</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>Add Show</h2>   
<h3>
<% String s=(String)request.getAttribute("msgy");
   if(s!=null)
   { %>Show Added and hall Mapped Successfully!!<% } %>
 <% String msg=(String)request.getAttribute("msgn");
   if(msg!=null)
   { %>Hall Code already taken!!<br>Try with a different hall code<% } %><br></h3>
After successfully adding the show in a hall, you will be redirected to mapping of that hall to select the required plan layout for the hall.     
<form method ="post" action="http://localhost:8089/NiitProject/AddShow">
<p>Select a Movie <%@ include file="MoviesView.jsp"  %> </p>
<p>Select a Site <%@ include file="SitesView.jsp"  %>  </p>
<p>Enter name of Theater <input type ="text" name="theater" />
<p>Enter Show start time <input type ="text" name="stime" />
<p>Enter Show end time <input type ="text" name="etime" />
<p>Enter hall code <input type ="text" name="hall" />
<p>Enter minimum ticket price <input type ="text" name="price" />
<p><button type="submit">Add</button></p>
</form>
</body>
</html>