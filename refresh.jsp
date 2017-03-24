<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<%  Connection con=null;
    Statement stmt=null;
try { 
   	Class.forName("oracle.jdbc.driver.OracleDriver"); 
   	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
   	 stmt=con.createStatement();
   	 
   } catch (Exception e) {
   	// TODO Auto-generated catch block
   	e.printStackTrace();
   }

%>   
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Refresh Seat Availability Status</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/refresh.jsp">Refresh All Seats</a></li>
  <li><a href="http://localhost:8089/NiitProject/refTheater.jsp">Refresh Specific theater Seats</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>Refresh All Seats</h2>
<% String v=request.getParameter("refresh");
   if(v!=null){
   try{ 
    stmt.execute("update seatmap set isvalid=1 where isvalid=2");
    stmt.close();
    con.close();
   }
   catch(Exception e)
   { e.printStackTrace(); } 
 %><p>All Seats refreshed Successfully !
 <% 
   }
%>
<form method="get" action="http://localhost:8089/NiitProject/refresh.jsp">
<p>Click on the below button to refresh/unbook seats of all theaters at all sites.</p>
<input type="hidden" name="refresh" value="2">
<p><input type="submit" value="Refresh">
</form>
</body>
</html>