package com;
import java.sql.*;

import java.io.FileWriter;
import java.io.IOException;

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
 * Servlet implementation class AddMovie
 */
@WebServlet("/AddMovie")
@MultipartConfig(location="e:/eclipseprog/workspace/NiitProject/WebContent/files") 
public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	int flag=1; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovie() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String movie=(String)request.getParameter("moviename");
		String release=(String)request.getParameter("release");
		String time=(String)request.getParameter("time");
		String intro=(String)request.getParameter("intro");
		String cast=(String)request.getParameter("cast");
		
				try{ 
			rs=stmt.executeQuery("select * from movies");
	     while(rs.next())
	     {
	    	 if( rs.getString(1).equals(movie)==true)
	    	 { flag=0;
	    	   break;
	    	 }
	     }
	     if(flag==1)
		 {   
	    	 String query="insert into movies values('"+movie+"','"+release+"','"+time+"')";
	    	 stmt.execute(query);
	    	 FileWriter fw= new FileWriter("e:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+".txt");  
	   	  fw.write(intro);
	   	  fw.close();
	   	  FileWriter fw_c= new FileWriter("e:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+"cast.txt");   
	   	  fw_c.write(cast);
	   	  fw_c.close();
	   	  Part poster=request.getPart("poster");
	   	  poster.write(movie+".jpg");
	      RequestDispatcher rd=request.getRequestDispatcher("AddMovie.jsp");
	      request.setAttribute("addmovie",movie);
	      rd.forward(request, response);
	    	   
		 }
	     else
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("AddMovie.jsp");
	    	   request.setAttribute("msg","n");
	    	   rd.forward(request, response);
			   flag=1;
	     }
	 

	}
	catch (Exception e)
	{  e.printStackTrace();}
  }

}


