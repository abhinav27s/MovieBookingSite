<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% RequestDispatcher rd1=request.getRequestDispatcher("StyleMenu.jsp"); 
   rd1.include(request,response); %>
<style>
#abc {
    width: 10px;
    height: 10px;
    background-color: #ffffff;
  }
#def {
    width: 10px;
    height: 10px;
    border: 2px inset gray;
    background-color: #ffaa44;
    /*margin-bottom: 1em;*/
  }  
</style>   
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Seats Mapping</h1>
<ul>
  <li><a href="http://localhost:8089/NiitProject/BookSeat.jsp">Back</a></li>
</ul>
<h2>Seats Available</h2>
<% ArrayList<Integer> ar=new ArrayList<>(100);
ArrayList<Integer> ar2=new ArrayList<>(100);
Integer row=(Integer)request.getAttribute("rows");
Integer col=(Integer)request.getAttribute("cols");
String site=(String)request.getAttribute("site");
String theater=(String)request.getAttribute("theater");
String hall=(String)request.getAttribute("hall");
String email=(String)request.getAttribute("email");
 if(row!=null && col!=null)
 {	 
int  r=row;
int c=col;
ar=(ArrayList)request.getAttribute("array");
ar2=(ArrayList)request.getAttribute("arrayBooked");

%>
<form action="http://localhost:8089/NiitProject/SeatBook" method="get">
<table>
<%
if(ar!=null)
{ 
int j=0,k=0;
for(int i=1;i<=r*c;i++)
{ if(i%c==1) {%><tr>
<% }
 if(j<ar.size() && ar.get(j)==i)
 { %>
   <td><input type="checkbox" name="chkSinglebook" id =<%=i%> value=<%=i %>></td>
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
ar.removeAll(ar);%></table>
<input type="hidden" name="site" value=<%=site %> >
<input type="hidden" name="theater" value=<%=theater %> >
<input type="hidden" name="hall" value=<%=hall %> >
<input type="hidden" name="Rows" value=<%=row %> >
<input type="hidden" name="Cols" value=<%=col %> >
<input type="hidden" name="email" value=<%=email %> >
<input type="submit" value="Book/Hold">
</form>
</body>
</html>