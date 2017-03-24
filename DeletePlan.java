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
 * Servlet implementation class DeletePlan
 */
@WebServlet("/DeletePlan")
public class DeletePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con=null;
	 Statement stmt=null;
	 ResultSet rs=null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlan() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		  try {
		    	Class.forName("oracle.jdbc.driver.OracleDriver"); 
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
				 stmt=con.createStatement();
			
		    	//String url="";
		    	//jdbc:oracle:thin:@localhost:1521:xe
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code=request.getParameter("pcode");
		try{
		stmt.execute("delete from plans where pcode='"+code+"'");
		RequestDispatcher rd=request.getRequestDispatcher("DeletePlan.jsp");
		request.setAttribute("delete","x");
		rd.forward(request,response);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
		
	}

}
