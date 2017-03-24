<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Connection con1=null;
Statement stmt1=null;
ResultSet rs1=null;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
	 stmt1=con1.createStatement();
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try{
	rs1=stmt1.executeQuery("select * from sites order by siteLoc");%>
	
	<select name="site" >
<% 	while(rs1.next())
	{ %>
	<option> 
	<%= rs1.getString(2) %>
	</option>
	<% } %> 
	</select>
<%	rs1.close();
	stmt1.close();
	con1.close();
}
catch(Exception e)
{ }

%>