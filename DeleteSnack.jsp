<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
} %>
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
<h2>Delete Snacks</h2>
<% String s=(String)request.getAttribute("delete");
   if(s!=null)
   {%><%=s %>  Deleted Successfully !<% } %>
<p>Select the Snack to be deleted-</p>
<form method="get" action="http://localhost:8089/NiitProject/DeleteSnack">
<% 
try{
	rs=stmt.executeQuery("select * from snacks order by price ");
	while(rs.next())
	{%><p><label><input type="radio" name="snack" value="<%=rs.getString(1) %>" ><%=rs.getString(1) %> </label></p>
<% 	}		
   }	
catch(Exception e)
{ e.printStackTrace(); }
    rs.close();
	stmt.close();
	con.close();
	%>
<p><button type="submit">Delete</button>	
</form>

</body>
</html>