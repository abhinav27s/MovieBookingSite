package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewTheater
 */
@WebServlet("/ViewTheater")
public class ViewTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTheater() {
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
			 stmt=con.createStatement();
			
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
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{ }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String site=request.getParameter("site");
		PrintWriter pw=response.getWriter();
		try{ rs=stmt.executeQuery("select * from theaters where site='"+site+"'");
		pw.println("<html><body><h1>Theaters in "+site+" are-</h1><table>");
	     while(rs.next())
	     { pw.println("<tr><td>"+rs.getString(1)+"</td></tr>");
	       	
	     }
		pw.println("</table></body></html>");
		   }
	     catch(Exception e)
	     { }
	
	}

}
