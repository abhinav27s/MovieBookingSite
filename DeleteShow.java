package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteShow
 */
@WebServlet("/DeleteShow")
public class DeleteShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null,stmt2=null;
	ResultSet rs=null;
	int flag=0;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShow() {
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
			 stmt2=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
			stmt2.close();
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
		String hall=(String)request.getParameter("hall");
		String stime=(String)request.getParameter("stime");
		try{ 
			rs=stmt.executeQuery("select * from shows where movie='"+movie+"'");
	     while(rs.next())
	     {
	    	 if( rs.getString(2).equals(site)==true && rs.getString(3).equals(theater)==true && rs.getString(4).equals(hall)==true && rs.getString(5).equals(stime)==true)
	    	 { flag=1;
	    	   break;
	    	 }
	     }
	     if(flag==1)
		 {   
	    	 String query="delete from shows where movie='"+movie+"' and site='"+site+"' and theater='"+theater+"' and hall='"+hall+"' and starttime='"+stime+"'";
	    	 stmt.execute(query);
	    	 stmt2.execute("delete from seatmap where site='"+site+"' and theater='"+theater+"' and hall='"+hall+"'");
	    	 RequestDispatcher rd=request.getRequestDispatcher("DeleteShow.jsp");
	    	   request.setAttribute("msgy","yes");
	    	   rd.forward(request, response);
	    	   
		 }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("DeleteShow.jsp");
	    	   request.setAttribute("msgn","no");
	    	   rd.forward(request, response);
			   flag=0;
	     }
		}
		catch (Exception e)
		{  e.printStackTrace();}

		
	}

}
