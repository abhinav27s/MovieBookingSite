<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Connection con=null;
Statement stmt=null;
ResultSet rs=null;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
	 stmt=con.createStatement();
    } 
catch (Exception e) {
	e.printStackTrace();
}
try{
	rs=stmt.executeQuery("select * from movies order by moviename");%>
	
	<select name="movie" >
<% 	while(rs.next())
	{ %>
	<option> 
	<%= rs.getString(1) %>
	</option>
	<% } %> 
	</select>
<%	rs.close();
	stmt.close();
	con.close();
}
catch(Exception e)
{ }

%>