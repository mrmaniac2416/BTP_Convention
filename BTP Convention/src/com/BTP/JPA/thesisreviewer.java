package com.BTP.JPA;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class thesisreviewer {
	
	
	@EmbeddedId
	private thesisreviewerPK thesisreviewerId;
	private String supervisorId;
	private String token;
	private Date sentDate;
	private String status;
	private Date acceptedDate;
	public thesisreviewerPK getThesisreviewerId() {
		return thesisreviewerId;
	}
	public void setThesisreviewerId(thesisreviewerPK thesisreviewerId) {
		this.thesisreviewerId = thesisreviewerId;
	}
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getAcceptedDate() {
		return acceptedDate;
	}
	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}
	
	
	

}
