package com.BTP.JPA;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class thesisreviewer {
	
	
	@EmbeddedId
	private thesisreviewerPK thesisreviewerId;
	@Column(name="supervisor_id")
	private String supervisorId;
	private String token;
	private Date sentdate;
	private String status;
	private Date accepteddate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSentdate() {
		return sentdate;
	}
	public void setSentdate(Date sentdate) {
		this.sentdate = sentdate;
	}
	public Date getAccepteddate() {
		return accepteddate;
	}
	public void setAccepteddate(Date accepteddate) {
		this.accepteddate = accepteddate;
	}
	
	

}
