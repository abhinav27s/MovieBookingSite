package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewSeatMap
 */
@WebServlet("/ViewSeatMap")
public class ViewSeatMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
   	Statement stmt=null;
   	ResultSet rs=null;   
   	ArrayList<Integer> ar=new ArrayList<>(10); 
	ArrayList<Integer> ar2=new ArrayList<>(10);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSeatMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 try {
		    	Class.forName("oracle.jdbc.driver.OracleDriver"); 
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
				 stmt=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
		    	//String url="";
		    	//jdbc:oracle:thin:@localhost:1521:xe
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try{
			//rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		// TODO Auto-generated method stub
		String ans=(String)session.getAttribute("answer");
		String site=request.getParameter("site");
		String theater=request.getParameter("theater");
		String hall=request.getParameter("hall");
		String book=request.getParameter("book");
		String email=request.getParameter("email");
		int k=0,r=0,c=0;
		try{
		rs=stmt.executeQuery("select * from seatmap where site='"+site+"' and theater='"+theater+"' and hall='"+hall+"' order by rowno,colmno");
	    while(rs.next())
	    { k++;
	      if(rs.getInt(8)==1)	
	       ar.add(k);
	      if(rs.getInt(8)==2)
	       ar2.add(k);	  
	      r=rs.getInt(6);
		  c=rs.getInt(7);
	    }
	   RequestDispatcher rd = null;
	    if(ans!=null){
	    rd=request.getRequestDispatcher("seatmap.jsp");
	    }
	    else if(book.equals("book")==true){ 
	    rd=request.getRequestDispatcher("seatbook.jsp");
	    }
	    else	
		rd=request.getRequestDispatcher("seatMap2.jsp");
	    request.setAttribute("rows",r);
	    request.setAttribute("cols",c);
	    request.setAttribute("array", ar);
	    request.setAttribute("arrayBooked", ar2);
	    request.setAttribute("site", site);
	    request.setAttribute("theater", theater);
	    request.setAttribute("hall",hall);
	    request.setAttribute("email", email);
	    //request.setAttribute("code", code);
	    rd.forward(request, response);
		}
		catch(Exception e)
		{ e.printStackTrace();
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
