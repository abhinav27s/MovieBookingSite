<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%  HttpSession s=request.getSession();
     String num=(String)s.getAttribute("n1");
     if(num!=null)
     {
    	 RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
    	 rd.forward(request,response);
     }	  
     else {	 %>	 
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CROWNZ CINEMAS</title>
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
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;   
}
.butt:hover {
    background-color: #008CBA; 
    color: white;
}
</style>
<body background="images/backfinal.jpg" >
<center>
<% RequestDispatcher rd2=request.getRequestDispatcher("MenuBar.jsp"); 
   rd2.include(request,response); %><br><br>
   <img  src="images/login.jpg"  alt="Smiley face"><br><br>
  <h3>MEMBER LOGIN</h3> 
<form method ="post" action="http://localhost:8089/NiitProject/Login" >
<table>
<tr><td>Email </td><td><input type="text" required name="t1"></td></tr><tr></tr>
<tr><td>Password </td><td><input type="password" required name="t2" ></td></tr>
</table><br>
<input type="submit" class="butt" value="Login">
</form>
<%
String x=(String)request.getAttribute("val");
if(x!=null)
{%>Invalid Email or Password!<%} }%>
</center>
</body>
</html>