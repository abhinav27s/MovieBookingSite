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
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class AddSeatMap
 */
@WebServlet("/AddSeatMap")
public class AddSeatMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null,stmt2=null,stmt3=null,stmtnew=null;
	ResultSet rs=null,rs2=null,rsnew=null;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSeatMap() {
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
			 stmt=con.createStatement();
			 stmt2=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 stmt3=con.createStatement();
			 stmtnew=con.createStatement();
			 
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
			rs2.close();
			rsnew.close();
			stmt.close();
			stmt2.close();
			stmt3.close();
			stmtnew.close();
			con.close();
		}
		catch(Exception e)
		{ }
	}

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String addshow=(String)session.getAttribute("addshow");
		String site=request.getParameter("site");
		String theater=request.getParameter("theater");
		String hall=request.getParameter("hall");
		String plan=request.getParameter("pcode");
		try{	
		rsnew=stmtnew.executeQuery("select * from seatmap where site='"+site+"' and theater='"+theater+"' and hall='"+hall+"'");	
		if(!rsnew.next())
		{rs=stmt.executeQuery("select * from plans where pcode='"+plan+"'");
		rs2=stmt2.executeQuery("select * from seatmap order by id");
		while(rs2.next());
		rs2.previous();
		int id=rs2.getInt(1)+1;
		while(rs.next()==true)
		{ String q="insert into seatmap values("+id+",'"+site+"','"+theater+"','"+hall+"','"+plan+"',"+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+")";
		  stmt3.execute(q); 
		  id++;
		}
		 if(addshow!=null)
		 { RequestDispatcher rd=request.getRequestDispatcher("AddShow.jsp");
		 request.setAttribute("msgy","msgy");
		 rd.forward(request,response);
		 }
		 else
		 {
		 RequestDispatcher rd=request.getRequestDispatcher("Addseatmap.jsp");
		 request.setAttribute("y","y");
		 rd.forward(request,response);
		 }
		}
		else
		{ if(addshow!=null)
		  { RequestDispatcher rd=request.getRequestDispatcher("AddShow.jsp");
		  request.setAttribute("msgn","msgn");
		  rd.forward(request,response);
		  }
		  else{
		  RequestDispatcher rd=request.getRequestDispatcher("Addseatmap.jsp");
		  request.setAttribute("n","n");
		  rd.forward(request,response);
		  }
		}
		}
		catch(Exception e)
		{e.printStackTrace(); }
		
	}

}
