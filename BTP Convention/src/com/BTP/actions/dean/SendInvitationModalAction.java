package com.BTP.actions.dean;

import com.BTP.JPA.deanaccountdetails;
import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionSupport;

public class SendInvitationModalAction extends ActionSupport{
	
	private String email;
	private int thesisId;
	private String body;
	private String subject;
	
	

	EmailService emailService=new EmailService();
	
	public String execute()
	{
		System.out.println(email);
		deanaccountdetails deanAccountDetails=this.emailService.fetchDeanEmailDetails();
		this.setBody(deanAccountDetails.getInvitationMailBody());
		this.setSubject(deanAccountDetails.getInvitationMailSubject());
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
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
