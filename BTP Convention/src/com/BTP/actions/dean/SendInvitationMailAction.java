package com.BTP.actions.dean;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="custom3")
public class SendInvitationMailAction extends ActionSupport{
	private String subject;
	private String body;

	private String email;
	private int thesisId;
	EmailService emailService = new EmailService();
	
	 @Actions( {
		    @Action(value = "send-invitation-mail", results = {
		      @Result(name = "success", type = "json"),
		      @Result(name="error",type="json",params= {"errorCode","400"})
		    })
		  })
	public String execute() {

		 System.out.println("in send inviataion mail");
		 return emailService.sendEmail(email, subject, body, thesisId);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesis_id) {
		this.thesisId = thesis_id;
	}

}
