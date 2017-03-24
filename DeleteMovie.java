package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteMovie
 */
@WebServlet("/DeleteMovie")
public class DeleteMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
		Connection con=null;
		Statement stmt=null,stmt2=null,stmt3=null,stmt4=null;
		ResultSet rs=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMovie() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
  		// TODO Auto-generated method stub
  		try {
  	    	Class.forName("oracle.jdbc.driver.OracleDriver"); 
  			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
  			 stmt=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
  			 stmt2=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
  			 stmt3=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
  			 stmt4=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
  			stmt2.close();
  			stmt3.close();
  			stmt4.close();
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
		String movie=(String)request.getParameter("movie");
		
		try{
		stmt.execute("delete from movies where moviename='"+movie+"'");
		rs=stmt2.executeQuery("select * from shows where movie='"+movie+"'");
		while(rs.next())
		 stmt3.execute("delete from seatmap where site='"+rs.getString(2)+"' and theater='"+rs.getString(3)+"' and hall='"+rs.getString(4)+"'");
	    stmt4.execute("delete from shows where movie='"+movie+"'");
		File f1=new File("E:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+".txt");
		File f2=new File("E:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+"cast.txt");
		File f3=new File("E:/eclipseprog/workspace/NiitProject/WebContent/files/"+movie+".jpg");
		f1.delete();
		f2.delete();
		f3.delete();
		 RequestDispatcher rd=request.getRequestDispatcher("DeleteMovie.jsp");
		 request.setAttribute("delete",movie);
		 rd.forward(request, response);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}

}
