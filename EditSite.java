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
 * Servlet implementation class EditSite
 */
@WebServlet("/EditSite")
public class EditSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSite() {
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
		String site=request.getParameter("site");
		String newsite=request.getParameter("newsite");
		try{
	    String query1="update sites set siteLoc='"+newsite+"' where siteLoc='"+site+"'";		
		stmt.execute(query1);
		String query2="update theaters set site='"+newsite+"' where site='"+site+"'";
		stmt.execute(query2);
		stmt.execute("update shows set site='"+newsite+"' where site='"+site+"'");
		stmt.execute("update seatmap set site='"+newsite+"' where site='"+site+"'");
		RequestDispatcher rd=request.getRequestDispatcher("Edit.jsp");
		request.setAttribute("y",newsite);
		rd.forward(request, response);
		}
		catch(Exception e)
		{ }
	}

}
