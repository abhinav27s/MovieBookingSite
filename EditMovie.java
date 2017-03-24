package com;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditMovie
 */
@WebServlet("/EditMovie")
public class EditMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovie() {
        super();
        // TODO Auto-generated constructor stub
    }
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
		//HttpSession session=null;
	// TODO Auto-generated method stub
	String movie=(String)request.getParameter("movie");
	String date=(String)request.getParameter("release");
	String time=(String)request.getParameter("duration");
	String intro=(String)request.getParameter("intro");
	String cast=(String)request.getParameter("cast");
	
	try{
	  stmt.execute("update movies set releasedate='"+date+"', duration='"+time+"' where moviename='"+movie+"'");
	  FileWriter fw= new FileWriter("E:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+".txt");   
	  fw.write(intro);
	  fw.close();
	  FileWriter fw_c= new FileWriter("E:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+"cast.txt");   
	  fw_c.write(cast);
	  fw_c.close();	

	 RequestDispatcher rd=request.getRequestDispatcher("EditMovie.jsp");
	 request.setAttribute("edit",movie);
	 rd.forward(request, response);
	}
	catch(Exception e)
	{ e.printStackTrace(); }
	

	}
		

}
