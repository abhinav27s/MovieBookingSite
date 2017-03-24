<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response);
   String site=(String)session.getAttribute("site");
   String theater=(String)session.getAttribute("theater");
   String hall=(String)session.getAttribute("hall");
   %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Seats Mapping</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/seatmap.jsp">View SeatMap</a></li>
  <li><a href="http://localhost:8089/NiitProject/Addseatmap.jsp">Add SeatMap</a></li>
  <li><a href="http://localhost:8089/NiitProject/DeleteSeatMap.jsp">Delete SeatMap</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>Add Seat Mapping</h2>
<%
String x=(String)request.getAttribute("y");
if(x!=null)
{ %>Seats mapped Successfully<% } %>
<%
String n=(String)request.getAttribute("n");
if(n!=null)
{ %>This hall is already mapped !!<% } %>
<form method="get" action="http://localhost:8089/NiitProject/AddSeatMap">
<% if(site!=null){ %>
<p>Site Name<input type="text" name="site" value=<%= site %>></p>
<p>Theater Name<input type="text" name="theater" value=<%= theater %>></p>
<p>Hall Name<input type="text" name="hall" value=<%= hall %>></p>
<%
session.setAttribute("addshow","addshow");   
}
 else {%>
<p> Select a Site
<%@ include file="SitesView.jsp"  %>
<p>Theater Name<input type="text" name="theater"></p>
<p>Hall Name<input type="text" name="hall" ></p>
<% } %><br>Select a Plan<br>
<p>Plan Code <%@ include file="ListPlans.jsp"  %>
<p><button type="submit">Map hall</button></p>
</form>
</body>
</html>