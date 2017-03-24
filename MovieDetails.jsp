<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>     
<%@ page import="java.io.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%  Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
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
<% String movie=request.getParameter("movie");
   rs=stmt.executeQuery("select * from movies where moviename='"+movie+"'");
   rs.next();
   //char[] intro=new char[100];
   char[] cast=new char[50];
   //FileReader fr1= new FileReader("E:/eclipseprog/workspace/NiitProject/files/"+movie+".txt");   
	 // fr1.read(intro);
	  
	  FileReader fr2= new FileReader("E:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+"cast.txt");   
	  fr2.read(cast);
	 	 
	 
%>
<h1>Movie Name - <%=movie %> </h1><br>
<h2>Edit Details</h2>
 
<form method="get" action="http://localhost:8089/NiitProject/EditMovie">
<p><input type="hidden" name="movie" value="<%=movie%>" >
<p>Movie Release Date<input type="date" name="release" value="<%= rs.getString(2) %>" >
<p>Movie Duration <input type="text" name="duration" value="<%=rs.getString(3) %>" >
<p>Movie Inroduction<br>
   <textarea name="intro" rows="10" cols="30" >
   <% 
   FileReader fr1 =new FileReader("E:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+".txt");
   while((x=fr1.read())!=-1)
   {%> <%=(char)x%> <%  }%>
   </textarea>
 </p>
 <p>Cast of Movie<br>
   <textarea name="cast" rows="5" cols="20" ><%=cast %></textarea>
  </p>
 <button type="submit">Save Details</button> 
 </form>
<% 
try{
	rs.close();
	stmt.close();
	con.close();
	fr1.close();
	fr2.close();
}
catch(Exception e)
{ e.printStackTrace(); }
%>
</form>
</body>
</html>