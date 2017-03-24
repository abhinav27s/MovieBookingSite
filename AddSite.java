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
 * Servlet implementation class AddSite
 */
@WebServlet("/AddSite")
public class AddSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	int flag;
	int site_c=1;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSite() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String site_n=(String)request.getParameter("sitename");
		//String site_c=(String)request.getParameter("sitename");
		// int site_c=Integer.parseInt(request.getParameter("sitecode"));
		try{ 
			rs=stmt.executeQuery("select * from sites order by siteId");
	     while(rs.next())
	     {
	    	 if( rs.getString(2).equals(site_n)==true)
	    	 { flag=0;
	    	   break;
	    	 }
	     }
	     if(flag==1)
		 {   if(rs.previous()==true)
		     site_c=rs.getInt(1)+1;
	    	 String query="insert into sites values("+site_c+",'"+site_n+"')";
	    	 stmt.execute(query);
	    	 /*FileWriter fw=new FileWriter("sites.txt");
	    	 fw.write(site_n);
	    	 fw.close();*/
	    	 RequestDispatcher rd=request.getRequestDispatcher("AddSite.jsp");
	    	   request.setAttribute("addsite","x");
	    	   rd.forward(request, response);
	    	   
		 }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("AddSite.jsp");
	    	   request.setAttribute("msg","y");
	    	   rd.forward(request, response);
			   flag=1;
	     }
	}
	catch (Exception e)
	{  e.printStackTrace();}
	}

}
