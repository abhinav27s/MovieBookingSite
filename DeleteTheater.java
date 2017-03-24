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
 * Servlet implementation class DeleteTheater
 */
@WebServlet("/DeleteTheater")
public class DeleteTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null,stmt2=null,stmt3=null;
	ResultSet rs=null;   
	int flag;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTheater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		flag=0;
		try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver"); 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
			 stmt=con.createStatement();
			 stmt2=con.createStatement();
			 stmt3=con.createStatement();
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
			stmt2.close();
			stmt3.close();
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
		String n=request.getParameter("n");
		String site=request.getParameter("site");
		try{
			rs=stmt.executeQuery("select * from theaters");
			while(rs.next())
			{ if(rs.getString(1).equals(n)==true && rs.getString(2).equals(site)==true)
			  {  flag=1;
			     break;
			  }	
			}
			if(flag==1)
			{		
			String query="delete from theaters where name='"+n+"' and site='"+site+"'";
			stmt.execute(query);
			stmt2.execute("delete from shows where theater='"+n+"' and site='"+site+"'");
			stmt3.execute("delete from seatmap where site='"+site+"' and theater='"+n+"'");
			RequestDispatcher rd=request.getRequestDispatcher("DeleteTheater.jsp");
			request.setAttribute("e","e");
			rd.forward(request, response);
			}
			else
			{ RequestDispatcher rd=request.getRequestDispatcher("DeleteTheater.jsp");
			request.setAttribute("msg",n);
			rd.forward(request, response);	
			}		
			}
			catch(Exception e)
			{ }
	}

}
