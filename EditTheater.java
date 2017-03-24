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
 * Servlet implementation class EditTheater
 */
@WebServlet("/EditTheater")
public class EditTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;   
	int flag;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTheater() {
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
		String n1=request.getParameter("n1");
		String n2=request.getParameter("n2");
		String site=request.getParameter("site");
		try{
			rs=stmt.executeQuery("select * from theaters");
			while(rs.next())
			{ if(rs.getString(1).equals(n1)==true && rs.getString(2).equals(site)==true)
			  {  flag=1;
			     break;
			  }	
			}
			if(flag==1)
			{		
			String query2="update theaters set name='"+n2+"' where name='"+n1+"' and site='"+site+"'";
			stmt.execute(query2);
			stmt.execute("update shows set theater='"+n2+"' where theater='"+n1+"' and site='"+site+"'");
			stmt.execute("update seatmap set theater='"+n2+"' where theater='"+n1+"' and site='"+site+"'");
			RequestDispatcher rd=request.getRequestDispatcher("EditTheater.jsp");
			request.setAttribute("e","e");
			rd.forward(request, response);
			}
			else
			{ RequestDispatcher rd=request.getRequestDispatcher("EditTheater.jsp");
			request.setAttribute("msg",n1);
			rd.forward(request, response);	
			}		
			}
			catch(Exception e)
			{ }
		
	}

}
