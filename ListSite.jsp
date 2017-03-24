<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<style>
table, th, td {
   border: 1px solid black;
   border-collapse: collapse;
}
</style>   
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Sites Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/ListSite.jsp">View Sites</a></li>
  <li><a href="http://localhost:8089/NiitProject/AddSite.jsp">Add Site</a></li>
  <li><a href="http://localhost:8089/NiitProject/Edit.jsp">Edit Site</a></li>
  <li><a href="http://localhost:8089/NiitProject/Delete.jsp">Delete Site</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>View Sites</h2>
<% Connection con=null;
Statement stmt=null;
ResultSet rs=null;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
	 stmt=con.createStatement();
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try{
	rs=stmt.executeQuery("select * from sites order by siteId");%>
	<table><tr><th>Site Code</th><th>Site Location</th></tr>
<% while(rs.next())
  {%><tr><td><%=rs.getInt(1) %></td><td><%=rs.getString(2) %></td></tr><% } %>	
  <%
    rs.close();
	stmt.close();
	con.close();
   }
catch(Exception e)
{ }  
  %>	
	</table>

</body>
</html>