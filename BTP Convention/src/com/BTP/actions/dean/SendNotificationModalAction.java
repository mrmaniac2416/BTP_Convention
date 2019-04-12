package com.BTP.actions.dean;

import com.BTP.JPA.deanaccountdetails;
import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionSupport;

public class SendNotificationModalAction extends ActionSupport{
	
	private String email;
	private String body;
	private String subject;
	
	

	EmailService emailService=new EmailService();
	
	public String execute()
	{
		System.out.println(email);
		deanaccountdetails deanAccountDetails=this.emailService.fetchDeanEmailDetails();
		this.setBody(deanAccountDetails.getSendNotificationMailBody());
		this.setSubject(deanAccountDetails.getSendNotificationMailSubject());
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
