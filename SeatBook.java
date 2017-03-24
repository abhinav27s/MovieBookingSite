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
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SeatBook
 */
@WebServlet("/SeatBook")
public class SeatBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
   	Statement stmt=null,stmt0=null;
   	ResultSet rs=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatBook() {
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
				stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				stmt0=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
		    	//String url="";
		    	//jdbc:oracle:thin:@localhost:1521:xe
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void destroy() {
		// TODO Auto-generated method stub
		try{
			rs.close();
			stmt.close();
			stmt0.close();
			con.close();
		}
		catch(Exception e)
		{ }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			
			String[] ar=(request.getParameterValues("chkSinglebook"));
			int [] br=new int[ar.length];
			for(int k=0;k<ar.length;k++)
			{
				br[k]=Integer.parseInt(ar[k]);
			}
			Arrays.sort((br));
			int r=Integer.parseInt(request.getParameter("Rows"));
			int c=Integer.parseInt(request.getParameter("Cols"));
			String site=(String)request.getParameter("site");
			String theater=(String)request.getParameter("theater");
			String hall=(String)request.getParameter("hall");
			String email=(String)request.getParameter("email");
			int ri,ci;
			int j=0,f=0;
			String q,id = null;
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
				{   if(f==0){
					rs=stmt0.executeQuery("select id from seatmap where site='"+site+"' and theater='"+theater+"' and hall='"+hall+"' and rowno="+ri+"and colmno="+ci);
				    rs.next();		
					id=""+rs.getInt(1);    
				    f=1;
				    }
					q="update seatmap set isvalid=2 where site='"+site+"' and theater='"+theater+"' and hall='"+hall+"' and rowno="+ri+"and colmno="+ci;
					stmt.execute(q);
					j++;
				}
			
				}	
			}
			//System.out.println(id);
			RequestDispatcher rd=request.getRequestDispatcher("Mail");
			request.setAttribute("email",email);
			request.setAttribute("id",id);
			request.setAttribute("site",site);
			request.setAttribute("theater",theater);
			rd.forward(request,response);
		}
			catch(Exception e)
			{
			e.printStackTrace();
			}
	}

}
