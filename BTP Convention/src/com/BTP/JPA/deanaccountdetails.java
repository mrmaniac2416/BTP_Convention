package com.BTP.JPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
public class deanaccountdetails {
	
	@Id
	private String email;
	private String password;
	@Column(name="invitation_mail_body")
	private String invitationMailBody;
	@Column(name="invitation_mail_subject")
	private String invitationMailSubject;
	@Column(name="send_notification_mail_body")
	private String sendNotificationMailBody;
	@Column(name="send_notification_mail_subject")
	private String sendNotificationMailSubject;
	public String getInvitationMailBody() {
		return invitationMailBody;
	}
    
	
	public void setInvitationMailBody(String invitationMailBody) {
		this.invitationMailBody = invitationMailBody;
	}

	public String getInvitationMailSubject() {
		return invitationMailSubject;
	}
	public void setInvitationMailSubject(String invitationMailSubject) {
		this.invitationMailSubject = invitationMailSubject;
	}

	

	public String getSendNotificationMailBody() {
		return sendNotificationMailBody;
	}

	public void setSendNotificationMailBody(String sendNotificationMailBody) {
		this.sendNotificationMailBody = sendNotificationMailBody;
	}

	public String getSendNotificationMailSubject() {
		return sendNotificationMailSubject;
	}

	public void setSendNotificationMailSubject(String sendNotificationMailSubject) {
		this.sendNotificationMailSubject = sendNotificationMailSubject;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
