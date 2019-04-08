package com.BTP.JPA;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class review {
	
	@EmbeddedId
	private reviewPK reviewId;
	private byte[] review;
	private Date submissiondate;
	public reviewPK getReviewId() {
		return reviewId;
	}
	public void setReviewId(reviewPK reviewId) {
		this.reviewId = reviewId;
	}
	public byte[] getReview() {
		return review;
	}
	public void setReview(byte[] review) {
		this.review = review;
	}
	public Date getSubmissiondate() {
		return submissiondate;
	}
	public void setSubmissiondate(Date submissiondate) {
		this.submissiondate = submissiondate;
	}

	
	

}
