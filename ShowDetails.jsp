<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
     <%@ page import="javax.servlet.RequestDispatcher" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%  Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    int x;
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
<% String movie=request.getParameter("movie");
String site=request.getParameter("site");
String theater=request.getParameter("theater");
String hall=request.getParameter("hall");
String stime=request.getParameter("stime");
   rs=stmt.executeQuery("select * from shows where movie='"+movie+"' and site='"+site+"' and theater='"+theater+"' and hall='"+hall+"' and starttime='"+stime+"'");
   rs.next();
  
%>

<h2>Edit Show Details</h2>
 
<form method="post" action="http://localhost:8089/NiitProject/EditShow">
<p>Movie Name<input type="text" name="movie" value="<%= rs.getString(1) %>" >
<p>Site  -<input type="hidden" name="site" value="<%= rs.getString(2) %>"><%= rs.getString(2) %>
<p>Theater  -<input type="hidden" name="theater" value="<%=rs.getString(3) %>" ><%=rs.getString(3) %>
<p>Hall  -<input type="hidden" name="hall" value="<%=rs.getString(4) %>" ><%=rs.getString(4) %>
<input type="hidden" name="hallold" value="<%=rs.getString(4) %>" >
<p>Show Start Time<input type="text" name="stime" value="<%=rs.getString(5) %>" >
<input type="hidden" name="stimeold" value="<%=rs.getString(5) %>" >
<p>Show End Time<input type="text" name="etime" value="<%=rs.getString(6) %>" >
<p>Minimum Ticket Price<input type="text" name="price" value="<%=rs.getString(7) %>" >
<p><button type="submit">Save Details</button> 
 </form>
 <%
try{
	rs.close();
	stmt.close();
	con.close();
}
catch(Exception e)
{ e.printStackTrace(); }
%>
</body>
</html>