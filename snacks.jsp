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
<h1>Snacks Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/snacks.jsp">View Snacks</a></li>
  <li><a href="http://localhost:8089/NiitProject/AddSnack.jsp">Add Snack</a></li>
  <li><a href="http://localhost:8089/NiitProject/DeleteSnack.jsp">Delete Snack</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>View Snacks</h2>
<% Connection con=null;
Statement stmt=null;
ResultSet rs=null;
String name;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
	 stmt=con.createStatement();
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try{
	rs=stmt.executeQuery("select * from snacks order by price ");%>
<ul id="products" >
<% while(rs.next())
  {  name=rs.getString(1); 
  
  %><li>
    <a href="#"><img style="width:150px" src="e:/eclipseprog/workspace/NiitProject/files/snacks_pics/<%=name%>.jpg" ><br>
    <%=name   %><br>
    Rs.<%=rs.getInt(2) %></a></li>
<%} %>
</ul>	
  <%
    rs.close();
	stmt.close();
	con.close();
   }
catch(Exception e)
{ }  
  %>	
	

</body>
</html>