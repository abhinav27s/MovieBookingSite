<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<%  Connection con=null;
    Statement stmt=null,stmt2=null;
    ResultSet rs=null;
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
<h2>Refresh Specific Theater Seats</h2>
<% String site=request.getParameter("site");
String theater=request.getParameter("theater");
   if(site!=null & theater!=null){
   try{ 
	rs=stmt.executeQuery("select * from seatmap where site='"+site+"' and theater='"+theater+"' and isvalid=2"); 
	if(rs.next()){
    stmt2.execute("update seatmap set isvalid=1 where site='"+site+"' and theater='"+theater+"' and isvalid=2");
    stmt2.close();
	}
    stmt.close();
    con.close();
   }
   catch(Exception e)
   { e.printStackTrace(); } 
 %><p>Seats refreshed Successfully for this theater !
 <% 
   }
%>
<form method="get" action="http://localhost:8089/NiitProject/refTheater.jsp">
Select a site 
<%@ include file="SitesView.jsp"  %><br><br>
Enter Theater Name<input type="text" name="theater"><br><br>
<p><input type="submit" value="Refresh">
</form>
</body>
</html>