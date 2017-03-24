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
//import java.io.IOException;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	int flag;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String name= req.getParameter("t1");
		String email= req.getParameter("t2");
		String phone= req.getParameter("t3");
		String pwd= req.getParameter("t4");
			try{ rs=stmt.executeQuery("select * from ProjectData");
		     while(rs.next())
		     {
		    	 if((rs.getString(1)).equals(email)==true)
		    	 { flag=0;
		    	   break;
		    	 }
		     }
		     if(flag==1)
			 { String query="insert into ProjectData values("+"'"+email+"',"+"'"+pwd+"',"+"'"+name+"',"+phone+")";
		    	 stmt.execute(query);
		    	 RequestDispatcher rd=req.getRequestDispatcher("Register.jsp");
		    	   req.setAttribute("name", name );
		    	   rd.forward(req, res);
		    	   
			 }
		     else
		     {
		    	 RequestDispatcher rd=req.getRequestDispatcher("Register.jsp");
		    	   req.setAttribute("vl","er" );
		    	   rd.forward(req, res);
				   flag=1;
		     }
		}
		catch (Exception e)
		{ }
	}

}
