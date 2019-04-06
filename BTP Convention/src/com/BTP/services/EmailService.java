package com.BTP.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

import com.BTP.JPA.*;

public class EmailService {
	
	private String from="pdhruv1109@gmail.com";
	private String password="ms1234ms";
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
	
	public void generateUser(int thesisId, String email)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(reviewer.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		org.hibernate.Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from users where user_id=:email");
		q.setParameter("email", email);
		users user = (users) q.uniqueResult();
		String subject;
		String text;
		if(user==null)
		{
			Date date = Calendar.getInstance().getTime();  
			DateFormat dateFormat = new SimpleDateFormat("sshhdd");  
			String passwd = dateFormat.format(date);
			Query q1 = session.createQuery("select r.name from reviewer r join thesisreviewer tr on r.reviewerId.email=tr.thesisreviewerId.reviewerId and r.reviewerId.supervisor_id=tr.supervisorId where tr.thesisreviewerId.thesisId=:thesisId and tr.thesisreviewerId.reviewerId=:email");
			q1.setParameter("email", email);
			q1.setParameter("thesisId", thesisId);
			String name = (String) q1.uniqueResult();
			users reviewer = new users();
			reviewer.setUser_id(email);
			reviewer.setPasswd(passwd);
			reviewer.setUser_type("reviewer");
			reviewer.setUser_name(name);
			session.save(reviewer);
			subject = "Login credentials";
	        text = "User-Id: "+ email + "\n Password: " + passwd;
		}
		else
		{
			subject="Thesis Added in Dashboard";
			text="Plase review the thesis";
		}
		
		
		
		
		
		
		
		String ret = "success";
		try {
			Session session1 = Session.getDefaultInstance(properties,  
					new javax.mail.Authenticator() {
				protected PasswordAuthentication 
				getPasswordAuthentication() {
					return new 
							PasswordAuthentication(from, password);
				}
			}
					);


			Message message = new MimeMessage(session1);
			/*
			 * message.setFrom(new InternetAddress(from));
			 * message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			 * message.setSubject(subject);
			 */
			/* message.setText(body); */
			message.setFrom(new InternetAddress("pdhruv1109@gmail.com"));
			System.out.println(email);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
			
			
			
			
			
		
			
			
			
		} catch(Exception e) {
			ret = "error";
			e.printStackTrace();
		}
//		return ret;
		String stat ="addedToDashboard";
		Query q2 = session.createQuery("update thesisreviewer set status=:stat where thesisreviewerId.reviewerId=:email and thesisreviewerId.thesisId=:thesisId");
        q2.setParameter("stat", stat);
        q2.setParameter("thesisId", thesisId);
        q2.setParameter("email", email);
        String thesisStatus = "reviewing";
        Query q3 = session.createQuery("update thesis set status=:thesisStatus where thesis_id=:thesisId");
        q3.setParameter("thesisStatus", thesisStatus);
        q3.setParameter("thesisId", thesisId);
		
		q2.executeUpdate();
		q3.executeUpdate();
		tx.commit();
		session.close();
		sf.close();
		
	}
}
