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
 * Servlet implementation class AddTheater
 */
@WebServlet("/AddTheater")
public class AddTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;   
	int flag;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTheater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		flag=1;
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
		String tname=request.getParameter("add");
		String site=request.getParameter("site");
		try{ rs=stmt.executeQuery("select * from theaters");
	     while(rs.next())
	     {
	    	 if((rs.getString(2)).equals(site)==true &&(rs.getString(1)).equals(tname)==true )
	    	 { flag=0;
	    	   break;
	    	 }
	     }
	     if(flag==1)
		 { String query="insert into theaters values("+"'"+tname+"',"+"'"+site+"')";
	    	 stmt.execute(query);
	    	 RequestDispatcher rd=request.getRequestDispatcher("AddTheater.jsp");
	    	   request.setAttribute("t",tname );
	    	   rd.forward(request, response);
	    	   
		 }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("AddTheater.jsp");
	    	   request.setAttribute("s","s" );
	    	   rd.forward(request, response);
			   flag=1;
	     }
	}
	catch (Exception e)
	{ }
	    
	}

}
