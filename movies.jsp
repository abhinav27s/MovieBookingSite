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
<h1>Movies Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/movies.jsp">View Movies</a></li>
  <li><a href="http://localhost:8089/NiitProject/AddMovie.jsp">Add Movie</a></li>
  <li><a href="http://localhost:8089/NiitProject/EditMovie.jsp">Edit Movie</a></li>
  <li><a href="http://localhost:8089/NiitProject/DeleteMovie.jsp">Delete Movie</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>View Movies</h2>
<% Connection con=null;
Statement stmt=null;
ResultSet rs=null;
String movie;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
	 stmt=con.createStatement();
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try{
	rs=stmt.executeQuery("select * from movies order by releasedate desc ");  //%>
	
<% while(rs.next())
  {  movie=rs.getString(1); 
  
  %><a href="http://localhost:8089/NiitProject/movieSummary.jsp?movie=<%=movie %>" ><%=movie %></a><br><br>
    <a href="http://localhost:8089/NiitProject/movieSummary.jsp?movie=<%=movie %>"><img style="width:200px" src="files/<%= movie %>.jpg" ></a><br><br><br>
<%} %>	
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