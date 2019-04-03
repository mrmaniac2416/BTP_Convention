package com.BTP.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.BTP.JPA.thesisreviewer;

public class EmailService {
	
	private String from="pdhruv1109@gmail.com";
	private String password="ms1234m";
	static Properties properties = new Properties();
	static {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "587");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable","true"); 
	}

	public String sendEmail(String email_id,String subject, String body, int thesis_id) {
		String ret = "success";
		try {
			Session session = Session.getDefaultInstance(properties,  
					new javax.mail.Authenticator() {
				protected PasswordAuthentication 
				getPasswordAuthentication() {
					return new 
							PasswordAuthentication(from, password);
				}
			}
					);

			Date date = Calendar.getInstance().getTime();  
			DateFormat dateFormat = new SimpleDateFormat("ssyyyyhhddmm");  
			String strDate = dateFormat.format(date);
			Random rand = new Random(); 
			int rand_int = rand.nextInt(10000); 
			strDate = strDate + Integer.toString(rand_int);


			Message message = new MimeMessage(session);
			/*
			 * message.setFrom(new InternetAddress(from));
			 * message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			 * message.setSubject(subject);
			 */
			/* message.setText(body); */
			message.setFrom(new InternetAddress("pdhruv1109@gmail.com"));
			System.out.println(email_id);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_id));
			message.setSubject("Hello");
			message.setText(body + "   http://localhost:8080/BTP_Convention/dean/accept-invitation.action?token=" + strDate);
			Transport.send(message);
			
			
			Date dat=new Date();
	        
	        Configuration con = new Configuration().configure().addAnnotatedClass(thesisreviewer.class);
	        
	        SessionFactory sf = con.buildSessionFactory();
	        
	        org.hibernate.Session sessionQuery = sf.openSession();
	       
	        Transaction tx = sessionQuery.beginTransaction();
	        
	        Query q = sessionQuery.createQuery("update thesisreviewer set sentdate=:date, token=:token where thesisreviewerId.reviewerId=:email_id");
	        q.setParameter("date", dat);
	        q.setParameter("token", strDate);
	        q.setParameter("email_id", email_id);
	        System.out.println("upload mein gaya");
	        
	        q.executeUpdate();
	        
	        tx.commit();
	        sessionQuery.close();
	        sf.close();
			
			
			
			
			
		
			
			
			
		} catch(Exception e) {
			ret = "error";
			e.printStackTrace();
		}
		return ret;
	}
}
