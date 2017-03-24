package com;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
//import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Servlet implementation class MailTry
 */
@WebServlet("/Mail")
public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String email=(String)request.getAttribute("email");
		  String id=(String)request.getAttribute("id");
		  String site=(String)request.getAttribute("site");
		  String theater=(String)request.getAttribute("theater");
	      String to = email;

	      // Sender's email ID needs to be mentioned
	      String from = "hackjack4321@gmail.com";

	      // Assuming you are sending email from localhost
	      //String host = "localhost";
          final String user="hackjack4321@gmail.com";
          final String pwd="systemhacker";
	      // Get system properties
	      Properties properties = System.getProperties();
	      // Setup mail server
	      properties.setProperty("mail.smtp.auth", "true");
	      properties.setProperty("mail.smtp.starttls.enable","true");
	      properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	      properties.setProperty("mail.smtp.port","587");
	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
          protected PasswordAuthentication getPasswordAuthentication(){
           return new PasswordAuthentication(user,pwd);
          } 
          });
	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Seat Booking Confirmation!");

	         // Now set the actual message
	         message.setText("Your seats are successfully booked with booking reference id CCN"+id+" at "+theater+" "+site+". Collect yout tickets from the ticket counter 15 min before the show time.");

	         // Send message
	         Transport.send(message);
	        // System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	  	RequestDispatcher rd=request.getRequestDispatcher("confirm.jsp");
	  	request.setAttribute("id",id);
		rd.forward(request,response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

