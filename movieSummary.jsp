<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>     
<%@ page import="java.io.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%  Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    int x,y;
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
String intro="",cast="";
 rs=stmt.executeQuery("select * from movies where moviename='"+movie+"'"); rs.next(); 
FileReader fr1 =new FileReader("E:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+".txt");
   while((x=fr1.read())!=-1)
   { intro=intro+(char)x; }
FileReader fr2 =new FileReader("E:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+"cast.txt");
   while((x=fr2.read())!=-1)
   { cast=cast+(char)x; }%>   
<p><h1><%=rs.getString(1) %></h1>
<p><img style="width:200px" src="files/<%= movie %>.jpg" >
<p><h2>Introduction</h2>
<p><%=intro %>
<p><h2>Cast of Movie</h2>
<p><%=cast %>
<p><h2>Release Date</h2> 
<%=rs.getString(2) %>
<p><h2>Duration of Movie</h2> 
<%=rs.getString(3) %>
<%
 rs.close();
stmt.close();
con.close();
fr1.close();
fr2.close();
%>
</body>
</html>