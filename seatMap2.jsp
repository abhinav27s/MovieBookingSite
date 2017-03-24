<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<style>
#abc {
    width: 20px;
    height: 20px;
    background-color: #ffffff;
  }
#def {
    width: 20px;
    height: 20px;
    border: 2px inset gray;
    background-color: #ffaa44;
    /*margin-bottom: 1em;*/
  }  
 #pqr {
    width: 20px;
    height: 20px;
    border: 2px inset gray;
    background-color: #ffffff;
  } 
</style>   
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Seats Mapping</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/Book.jsp">Back</a></li>
</ul>
<h2>Seats Available</h2>
<% ArrayList<Integer> ar=new ArrayList<>(100);
ArrayList<Integer> ar2=new ArrayList<>(100);
Integer row=(Integer)request.getAttribute("rows");
Integer col=(Integer)request.getAttribute("cols");
 if(row!=null && col!=null)
 {	 
int  r=row;
int c=col;
ar=(ArrayList)request.getAttribute("array");
ar2=(ArrayList)request.getAttribute("arrayBooked");
//String code=(String)request.getAttribute("code");
if(ar!=null)
{ %><table> <%
int j=0,k=0;
for(int i=1;i<=r*c;i++)
{ if(i%c==1) {%><tr>
<% }
 if(j<ar.size() && ar.get(j)==i)
 { %>
   <td><div id="pqr"></div></td>
<%  
   j++;
 }
 else if(k<ar2.size() && ar2.get(k)==i)
 { %> <td><div id="def"></div></td>  
 <% 	k++; 
 }
 else
 { %>
	<td><div id="abc"></div></td> 
<% }
}
}
}
ar.removeAll(ar);
ar2.removeAll(ar2);
%></table>
</body>
</html>