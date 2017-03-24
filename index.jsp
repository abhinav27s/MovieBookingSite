<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CROWNZ CINEMAS</title>
</head>
<style>
.abc {
     border-radius: 25px ;
     border: 2px solid #73AD21;
     opacity: 0.8;
     filter: alpha(opacity=80);
}
</style>
<div>
<% 
   RequestDispatcher rd2=request.getRequestDispatcher("MenuBar.jsp"); 
   request.setAttribute("a",0);
   rd2.include(request,response);
%>
  </div>
<body background="images/backfinal.jpg" ><br><br><br>
<center>
<h1 style="color:red">CROWNZ CINEMAS</h1>
<img class="abc" src="images/movie.jpg" height=400 >
</center>
</body>
</html>