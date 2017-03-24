package com;
import java.sql.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditShow
 */
@WebServlet("/EditShow")
public class EditShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	int flag=1;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditShow() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String movie=request.getParameter("movie");
		 String site=request.getParameter("site");
		 String theater=request.getParameter("theater");
		 String hall=request.getParameter("hall");
		 String hallold=request.getParameter("hallold");
		 String stime=request.getParameter("stime");
		 String stimeold=request.getParameter("stimeold");
		 String etime=request.getParameter("etime");
		 String price=request.getParameter("price");
		 try{
				
					
				String query2="update shows set hall='"+hall+"',starttime='"+stime+"',endtime='"+etime+"',price="+price+"where movie='"+movie+"' and site='"+site+"' and theater='"+theater+"' and hall='"+hallold+"' and starttime='"+stimeold+"'";
				stmt.execute(query2);
				RequestDispatcher rd=request.getRequestDispatcher("EditShow.jsp");
				request.setAttribute("msgy","yes");
				rd.forward(request, response);
					
			}
				catch(Exception e)
				{ }
	}

}
