package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/planlayout")
public class planlayout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public int count=0;
    Connection con=null;
   	Statement stmt=null;
   	ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public planlayout() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
		String[] ar=(request.getParameterValues("chkSingle"));
		int [] br=new int[ar.length];
		for(int k=0;k<ar.length;k++)
		{
			br[k]=Integer.parseInt(ar[k])+1;
		}
		Arrays.sort((br));
		
		String code=request.getParameter("code");
		int r=Integer.parseInt(request.getParameter("Rows"));
		int c=Integer.parseInt(request.getParameter("Cols"));
		int ri,ci;
		int j=0;
		String q;
		//stmt.executeUpdate("delete from pro");
		for(int i=1;i<=r*c;i++)
		{   
			if(i%c==0)
		    { ri=i/c;
			  ci=c;
		    }
		    else
		    { ri=(i/c)+1;
		      ci=i%c;	
		    }
			if(j<br.length)
			{ 
			if((br[j])==i)
			{   //System.out.println("hi");
			    q="insert into plans values('"+code+"',"+ri+","+ci+",0)";
				stmt.executeUpdate(q);
				j++;
			}
			else
				stmt.executeUpdate("insert into plans values('"+code+"',"+ri+","+ci+",1)");
			}
			else 
				stmt.executeUpdate("insert into plans values('"+code+"',"+ri+","+ci+",1)");	
		}
		RequestDispatcher rd=request.getRequestDispatcher("planlayout.jsp");
		request.setAttribute("x","x");
		rd.forward(request,response);
	}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}

}

