<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
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
    background-color: #555555; 
    color: white;
}
</style>
<body background="images/backfinal.jpg">
<% RequestDispatcher rd2=request.getRequestDispatcher("MenuBar.jsp"); 
   rd2.include(request,response); %><center><br>
   <img  src="images/register.jpg" height="200"  alt="Smiley face"><br><br>
   <form method ="post" action="http://localhost:8089/NiitProject/Register" >
<table>
<tr><td>Name </td><td><input type="text" required name="t1"></td></tr>
<tr><td>Email </td><td><input type="text" required name="t2"></td></tr>
<tr><td>Mobile Number </td><td><input type="number" required name="t3"></td></tr>
<tr><td>Password </td><td><input type="password" required name="t4" ></td></tr>
<tr><td>Confirm Password </td><td><input type="password" required name="t5"></td></tr>
</table><br>
<input type="submit" class="butt" value="Register">
</form>
<% 
String x=(String)request.getAttribute("name");
if(x!=null)
{%><p>Email Successfully Registered!</p><%} %>

<% 
String y=(String)request.getAttribute("vl");
if(y!=null)
{%><p>This email id is already registered!</p><%} %>
</center>
</body>
</html>