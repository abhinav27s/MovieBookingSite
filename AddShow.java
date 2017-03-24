package com;
import java.sql.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddShow
 */
@WebServlet("/AddShow")
public class AddShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	int flag=1;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShow() {
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
		try {
			rs.close();
			stmt.close();
			con.close();
			}
			catch(Exception e)
			{ e.printStackTrace(); }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movie=(String)request.getParameter("movie");
		String site=(String)request.getParameter("site");
		String theater=(String)request.getParameter("theater");
		String stime=(String)request.getParameter("stime");
		String etime=(String)request.getParameter("etime");
		String hall=(String)request.getParameter("hall");
		String price=(String)request.getParameter("price");
	    HttpSession session=request.getSession();
		
		try{ 
			rs=stmt.executeQuery("select * from shows where movie='"+movie+"'");
	     while(rs.next())
	     {
	    	 if( rs.getString(2).equals(site)==true && rs.getString(3).equals(theater)==true && rs.getString(4).equals(hall)==true)
	    	 { flag=0;
	    	   break;
	    	 }
	     }
	     if(flag==1)
		 {   
	    	 String query="insert into shows values('"+movie+"','"+site+"','"+theater+"','"+hall+"','"+stime+"','"+etime+"',"+price+")";
	    	 stmt.execute(query);
	    	 RequestDispatcher rd=request.getRequestDispatcher("Addseatmap.jsp");
	    	   session.setAttribute("site",site);
	    	   session.setAttribute("theater",theater);
	    	   session.setAttribute("hall",hall);
	    	   rd.forward(request, response);
	    	   
		 }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("AddShow.jsp");
	    	   request.setAttribute("msgn","no");
	    	   rd.forward(request, response);
			   flag=1;
	     }
		}
		catch (Exception e)
		{  e.printStackTrace();}
	
	}

}
