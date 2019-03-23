package com.BTP.JPA;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

@Entity

public class reviewer {
	
	@EmbeddedId
	private reviewerPK reviewerId;
	private String affiliation;
	private String designation;
	private String address;
	private String reviewer_type;
	private String contact_no;
	private String name;
	
	
	public reviewerPK getReviewerId() {
		return reviewerId;
	}
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
	public String getReviewer_type() {
		return reviewer_type;
	}
	public void setReviewer_type(String reviewer_type) {
		this.reviewer_type = reviewer_type;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
