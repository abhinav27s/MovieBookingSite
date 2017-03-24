<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.butt {
    background-color: #4CAF50; 
    border: none;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    border-radius: 50%;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;   
}
.butt:hover {
    background-color: #f44336; 
    color: white;
}
</style>
<body background="images/backfinal.jpg">
<center>
<% //RequestDispatcher rd2=request.getRequestDispatcher("MenuBar.jsp"); 
  // rd2.include(request,response); 
   String name= (String)session.getAttribute("name");
   String email= (String)session.getAttribute("email");
   //session.setAttribute("s", 10);
   
%>
<h1>Welcome
<%= name %><br><br>
<form>
<input type="hidden" name="email" >
<input type="hidden" name="name" >
</form>
<a href="http://localhost:8089/NiitProject/BookSeat.jsp?email=<%= email%>&name=<%= name%>">Book Movie Ticket</a>
</h1>
<a href="Logout">
<button class="butt" >Logout</button>
</a>
</center>
</body>
</html>