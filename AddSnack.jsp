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
<h1>Snacks Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/snacks.jsp">View Snacks</a></li>
  <li><a href="http://localhost:8089/NiitProject/AddSnack.jsp">Add Snack</a></li>
  <li><a href="http://localhost:8089/NiitProject/DeleteSnack.jsp">Delete Snack</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>Add Snacks</h2>
<% String s=(String)request.getAttribute("addsnack");
   if(s!=null)
   { %>Snack <%= s %> Added Successfully!!<% } %>
 <% String msg=(String)request.getAttribute("msg");
   if(msg!=null)
   { %>Snack Already Exists!!<% } %>
<form method ="post" enctype="multipart/form-data" action="http://localhost:8089/NiitProject/AddSnack">
<p>Enter Snack Name<input type="text" required name="x"></p>
<p>Enter Snack Price<input type="number" required name="y" ></p>
<p>Select Snack Image<input type="file"  name="picture" ></p>
<p><button type="submit">Add</button></p>
</form>
</body>
</html>