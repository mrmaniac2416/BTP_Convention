package com.BTP.actions.dean;

import org.apache.struts2.convention.annotation.Result;

import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionSupport;


@Result(name="success", location="display-reviewer-list", type="redirectAction",params= {"thesis_id", "${thesis_id}"})
public class SendInvitationMailAction extends ActionSupport{
	private String subject;
	private String body;
	private String email;
	private int thesis_id;
	EmailService emailService = new EmailService();
	
	
	public String execute() {
		return emailService.sendEmail(email, subject, body, thesis_id);
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

	public int getThesis_id() {
		return thesis_id;
	}

	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}

}
