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
<body>
<h1>Theater Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/Theaters.jsp">View Theaters</a></li>
  <li><a  href="http://localhost:8089/NiitProject/AddTheater.jsp">Add Theaters</a></li>
  <li><a  href="http://localhost:8089/NiitProject/EditTheater.jsp">Edit Theaters</a></li> 
  <li><a  href="http://localhost:8089/NiitProject/DeleteTheater.jsp">Delete Theaters</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>Edit Theaters</h2>
<form method="get" action="http://localhost:8089/NiitProject/EditTheater">
<p> Select a Site
<%@ include file="SitesView.jsp"  %>
<%--
RequestDispatcher r=request.getRequestDispatcher("SitesView.jsp");
r.include(request,response); 
--%>
</p>
<p>Enter name of Theater to be edited<input type="text" name="n1"></p>
<p>Enter new name of Theater<input type="text" name="n2"></p>
<p><button type="submit"> Submit</button></p>
</form>
<%
String x=(String)request.getAttribute("e");
if(x!=null)
{%><p>Theater Name Changed Successfully!</p><% } %>
<% 
String y=(String)request.getAttribute("msg");
if(y!=null)
{%><p>Theater <%=y %>does not exist at this site</p><%} %>
</body>
</html>