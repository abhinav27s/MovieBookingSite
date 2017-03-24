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
 * Servlet implementation class DeleteSeatMap
 */
@WebServlet("/DeleteSeatMap")
public class DeleteSeatMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
   	Statement stmt=null;
   	ResultSet rs=null;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSeatMap() {
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String site=request.getParameter("site");
		String theater=request.getParameter("theater");
		String hall=request.getParameter("hall");
		try{
		 stmt.execute("delete from seatmap where site='"+site+"' and theater='"+theater+"' and hall='"+hall+"'");
		 RequestDispatcher rd=request.getRequestDispatcher("seatmap.jsp");
		 request.setAttribute("x","x");
		 rd.forward(request, response);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}


}
