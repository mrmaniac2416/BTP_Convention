package com.BTP.actions.dean;

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

import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


//@Result(name="success", location="display-reviewer-list", type="redirectAction",params= {"thesisId", "${thesisId}"})
public class SendInvitationMailAction extends ActionSupport{

	private String from="pdhruv1109@gmail.com";
	private String password="ms1234ms";
	private String to;
	private String subject;
	private String body;
	private String email_id;
	private int thesisId;
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

	public String execute() {
		String ret = SUCCESS;
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

			Date date = new Date();  
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
			message.setText(body + "   http://localhost:8080/email?token=" + strDate);
			Transport.send(message);
		} catch(Exception e) {
			ret = ERROR;
			e.printStackTrace();
		}
		return ret;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		SendInvitationMailAction.properties = properties;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesis_id) {
		this.thesisId = thesis_id;
	}

}
