package com.BTP.JPA;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@Entity

public class reviewer {
	
	@EmbeddedId
	private reviewerPK reviewerId;
	private String affiliation;
	private String designation;
	private String address;
	@Column(name="reviewer_type")
	private String reviewerType;
	
	@Column(name="contact_no")
	private String contact;
	private String name;
	
	
	public reviewerPK getReviewerId() {
		return reviewerId;
	}
	
	@VisitorFieldValidator(message = "")
	public void setReviewerId(reviewerPK reviewerId) {
		this.reviewerId = reviewerId;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReviewerType() {
		return reviewerType;
	}
	
	@RequiredStringValidator(message = "Enter type.")
	@FieldExpressionValidator(message="Enter a type", expression="(reviewerType!='-1')" )
	public void setReviewerType(String reviewer_type) {
		this.reviewerType = reviewer_type;
	}
	public String getContact() {
		return contact;
	}
	
	@RegexFieldValidator(message="Enter a valid phone number.",regex="[+]?[0-9]{7,}")
	public void setContact(String contact_no) {
		this.contact = contact_no;
	}
	public String getName() {
		return name;
	}
	
	@RequiredStringValidator(message = "Enter Reviewer name.")
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
