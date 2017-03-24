<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%  Connection con=null;
    Statement stmt=null,stmt2=null;
    ResultSet rs=null,rs2=null;
    int x;
try { 
   	Class.forName("oracle.jdbc.driver.OracleDriver"); 
   	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
   	 stmt=con.createStatement();
   	stmt2=con.createStatement();
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
<%
String movie=(String)request.getParameter("movie");
String site=(String)request.getParameter("site");
%>
<h1>Shows are as below:-</h1>
<table>
<% 
try{ 
rs=stmt.executeQuery("select distinct theater from shows where movie='"+movie+"' and site='"+site+"'");
while(rs.next())
   {%><tr><th><%=rs.getString(1) %></th>
 <% rs2=stmt2.executeQuery("select * from shows where movie='"+movie+"' and site='"+site+"' and theater='"+rs.getString(1)+"' order by starttime");
    while(rs2.next())
     {%><td><%=rs2.getString(5) %></td>
   <%} %>
     </tr>
<% }
    }
catch(Exception e)
{ e.printStackTrace(); }
try{
	rs.close();
	rs2.close();
	stmt.close();
	stmt2.close();
	con.close();
}
catch(Exception e)
{e.printStackTrace(); }
%>
</table>
</body>
</html>