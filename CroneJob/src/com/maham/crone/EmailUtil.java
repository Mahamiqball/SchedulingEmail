package com.maham.crone;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	public static void sendEmail(String toEmail, String subject, String body){
		try
	    {
		  	
		  final String fromEmail = "<enter your email here>"; //requires valid gmail id
		  final String password = ""; // correct password for gmail id
		 
		  Authenticator auth = new Authenticator() {
				
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
		  };
		  
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "smtp.gmail.com"); 
		  props.put("mail.smtp.port", "587"); 
	      props.put("mail.smtp.auth", "true"); 
		  props.put("mail.smtp.starttls.enable", "true"); 
			
		  Session session = Session.getInstance(props, auth); 
		  MimeMessage msg = new MimeMessage(session);
		  
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("mahamiqbal990@gmail.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("mahamiqbal990@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
		
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}