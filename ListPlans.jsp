<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Connection con2=null;
Statement stmt2=null;
ResultSet rs2=null;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
	 stmt2=con2.createStatement();
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try{
	rs2=stmt2.executeQuery("select distinct pcode from plans");%>
	
	<select name="pcode" >
<% 	while(rs2.next())
	{ %>
	<option> 
	<%= rs2.getString(1) %>
	</option>
	<% } %> 
	</select>
<%	rs2.close();
	stmt2.close();
	con2.close();
}
catch(Exception e)
{ }

%>