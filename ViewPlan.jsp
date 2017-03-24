<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
#abc {
    width: 20px;
    height: 20px;
    background-color: #ffffff;
    /*margin-bottom: 1em;*/
  }
#def {
    width: 20px;
    height: 20px;
    border: 2px inset gray;
    background-color: #ffaa44;
    /*margin-bottom: 1em;*/
  }  
</style>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Plan Layout Settings</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/ViewPlan.jsp">View Plan Layout</a></li>
  <li><a  href="http://localhost:8089/NiitProject/planlayout.jsp">Add Plan</a></li>
  <li><a  href="http://localhost:8089/NiitProject/DeletePlan.jsp">Delete Plan</a></li>
  <li><a href="http://localhost:8089/NiitProject/AdminWelcm.jsp">Back to Menu</a></li>
</ul>
<h2>View Plan Layout</h2>
<% ArrayList<Integer> ar=new ArrayList<>(100);
Integer row=(Integer)request.getAttribute("rows");
Integer col=(Integer)request.getAttribute("cols");
 if(row!=null && col!=null)
 {	 
int  r=row;
int c=col;
ar=(ArrayList)request.getAttribute("array");
String code=(String)request.getAttribute("code");
if(code!=null)
{%>Plan Layout for plan code <%=code %><table> <% 
int j=0;	
for(int i=1;i<=r*c;i++)
{ if(i%c==1) {%><tr>
<% }
 if(j<ar.size())
 { 
    if((ar.get(j))==i)
   {  %>
   <td><div id="def"></div></td>
<%  
   j++;
   }
   else
   {%>
	 <td><div id="abc"></div></td>  
 <%  }
 }
 else
 { %>
	<td><div id="abc"></div></td> 
<% }
}
}
}
ar.removeAll(ar);%></table>
<form method="post" action="http://localhost:8089/NiitProject/ViewPlan">
Select the Plan Code to view its layout<br>
<%@ include file="ListPlans.jsp"  %>
<button type="submit">View Plan</button>
</form>
</body>
</html>