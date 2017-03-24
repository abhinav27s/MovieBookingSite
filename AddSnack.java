package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddSnack
 */
@WebServlet("/AddSnack")
@MultipartConfig(location="e:/eclipseprog/workspace/NiitProject/files/snacks_pics")
public class AddSnack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	int flag=1;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSnack() {
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
		int pr=0;
		String name=(String)request.getParameter("x");
		String price=(String)request.getParameter("y");
		if(price!=null)
		pr=Integer.parseInt(price);	
		try{ 
			rs=stmt.executeQuery("select * from snacks");
	     while(rs.next())
	     {
	    	 if( rs.getString(1).equals(name)==true)
	    	 { flag=0;
	    	   break;
	    	 }
	     }
	     if(flag==1)
		 {  
	    	 String query="insert into snacks values('"+name+"',"+pr+")";
	    	 stmt.execute(query);
	    	 Part poster=request.getPart("picture");
			  poster.write(name+".jpg");
	    	 RequestDispatcher rd=request.getRequestDispatcher("AddSnack.jsp");
	    	   request.setAttribute("addsnack",name);
	    	   rd.forward(request, response);
	    	   
		 }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("AddSnack.jsp");
	    	   request.setAttribute("msg","y");
	    	   rd.forward(request, response);
			   flag=1;
	     }
	    
	}
	catch(Exception e)
		{ e.printStackTrace(); }

  }
}
