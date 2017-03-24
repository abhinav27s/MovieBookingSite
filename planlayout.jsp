<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<head>
</head>
<body>
<h1>Plan Layout Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/ViewPlan.jsp">View Plan Layout</a></li>
  <li><a  href="http://localhost:8089/NiitProject/planlayout.jsp">Add Plan</a></li>
  <li><a  href="http://localhost:8089/NiitProject/DeletePlan.jsp">Delete Plan</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>Add Plan</h2>
<%
String s=(String)request.getAttribute("x");
if(s!=null)
{%>Plan Layout Added Successfully !<% } %>
<form action="http://localhost:8089/NiitProject/planlayout" method="post">
<% int p=1,q;
if(request.getParameter("Rows")!=null && s==null)
{
 p=Integer.parseInt(request.getParameter("Rows"));
 q=Integer.parseInt(request.getParameter("Cols"));
%>
Click on the boxes to make the seat invalid<br>
<input type="hidden"  name="Rows" value=<%=p %> /><br>
<input type="hidden"  name="Cols" value=<%=q %>  /><br>
<%  p=p*q;
int i;
for(i=0;i<p;i++)
	{%>
	 <input type="checkbox" name="chkSingle" id =<%=i%> value=<%=i %>>
	<%// System.out.println(m);
	if((i+1)%q==0)
	{%>
		<br>
	<%}
}%>
Enter a new Plan code for the above layout<input type="text" required name="code" /><br>
<button   >Click</button>
<%}%>
</form>
    Enter number of rows and columns!<br><br>
<form action="planlayout.jsp" method="POST">
Rows.  <input type="number" required name="Rows"  /><br><br>
cols.  <input type="number" required name="Cols" /><br><br>

<button>Display</button></form>
</body>
</html>