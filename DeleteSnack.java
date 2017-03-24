package com;

import java.io.File;
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
 * Servlet implementation class DeleteSnack
 */
@WebServlet("/DeleteSnack")
public class DeleteSnack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSnack() {
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
		// TODO Auto-generated method stub
		String snack=(String)request.getParameter("snack");
		try{
			stmt.execute("delete from snacks where name='"+snack+"'");
			File f1=new File("E:/eclipseprog/workspace/NiitProject/files/snacks_pics/"+snack+".jpg");
			f1.delete();
			 RequestDispatcher rd=request.getRequestDispatcher("DeleteSnack.jsp");
			 request.setAttribute("delete",snack);
			 rd.forward(request, response);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
		
	}

}
