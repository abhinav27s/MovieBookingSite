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
import javax.servlet.http.HttpSession;
//import java.io.IOException;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	int flag;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s=req.getSession();
		String email= req.getParameter("t1");
		String pwd= req.getParameter("t2");
			try{ rs=stmt.executeQuery("select * from ProjectData");
		     while(rs.next())
		     {
		    	 if((rs.getString(1)).equals(email)==true && (rs.getString(2)).equals(pwd)==true)
		    	 { String name=rs.getString(3);
		    	   RequestDispatcher rd;
		    	   if(email.equals("admin")==true)
		    	   {  rd=req.getRequestDispatcher("AdminWelcm.jsp"); }	 
		    	   else
		    	   {  rd=req.getRequestDispatcher("Welcome.jsp");    }
		    	   // req.setAttribute("name", name );
		    	   s.setAttribute("name",name);
		    	   s.setAttribute("email",email);
		    	   flag=1;
		    	   rd.forward(req, res);
		    	   break;
		    	 }
		     }
		     if(flag==0)
		     {
		    	 RequestDispatcher r=req.getRequestDispatcher("Login.jsp");
		    	   req.setAttribute("val", "er" );
		    	   r.forward(req, res);
		     }
		     
		    
		}
		catch (Exception e)
		{ e.printStackTrace();}
	}

}
