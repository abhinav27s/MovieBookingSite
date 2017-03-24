<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%  Connection con=null;
    Statement stmt=null;
    ResultSet rs=null,rs2=null;
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
<%
String movie=(String)request.getParameter("movie");
String site=(String)request.getParameter("site");
%>
<h1>Select the Show to be edited</h1>
<table>
<% 
try{ 
rs=stmt.executeQuery("select distinct theater from shows where movie='"+movie+"' and site='"+site+"'");
while(rs.next())
   {%><tr><th><%=rs.getString(1) %></th>
 <% rs2=stmt.executeQuery("select * from shows where movie='"+movie+"' and site='"+site+"' and theater='"+rs.getString(1)+"'");
    while(rs2.next())
     {%><td><a href="http://localhost:8089/NiitProject/ShowDetails.jsp?movie=<%=rs2.getString(1)%>&site=<%=rs2.getString(2)%>&theater=<%=rs2.getString(3)%>&hall=<%=rs2.getString(4)%>&stime=<%=rs2.getString(5)%>">
     <%=rs2.getString(5) %>
     </a></td>
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
	con.close();
}
catch(Exception e)
{ }
%>
</table>
<form>
<input type="hidden" name="movie" >
<input type="hidden" name="site" >
<input type="hidden" name="theater" >
<input type="hidden" name="hall" >
<input type="hidden" name="stime" >
</form>
</body>
</html>