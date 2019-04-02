package com.BTP.JPA;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class review {
	
	@EmbeddedId
	private reviewPK reviewId;
	private byte[] review;
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

	
	

}
