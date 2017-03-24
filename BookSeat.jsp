<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response);
   String email=request.getParameter("email");
   String name=request.getParameter("name");
   %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/backfinal.jpg">
<center>
<h1>Book a Show</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/Book.jsp?email=<%= email%>&name=<%= name%>">View Availability</a></li>
  <li><a href="http://localhost:8089/NiitProject/BookSeat.jsp?email=<%= email%>&name=<%= name%>">Book</a></li>
  <li><a href="http://localhost:8089/NiitProject/Welcome.jsp?email=<%= email%>&name=<%= name%>">Back to Menu</a></li>
</ul>
<h2>Book Seats</h2>
<%
String x=(String)request.getAttribute("x");
if(x!=null){
%><p>Seat Booked Successfully!</p>
<% } %>
<form method ="post" action="http://localhost:8089/NiitProject/ShowsView2.jsp">
<p>Select a Movie <%@ include file="MoviesView.jsp"  %> </p>
<p>Select a Site <%@ include file="SitesView.jsp"  %>  </p>
<input type="hidden" name="book" value="book">
<input type="hidden" name="email" value="<%= email%>">
<p><button type="submit">Book</button></p>
</form>
</center>
</body>
</html>