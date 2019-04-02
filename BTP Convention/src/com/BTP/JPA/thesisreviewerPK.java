package com.BTP.JPA;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class thesisreviewerPK implements Serializable{
	
	@Column(name="thesis_id")
	private int thesisId;
	@Column(name="reviewer_id")
	private String reviewerId;
	
	public thesisreviewerPK()
	{
		
	}

	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof thesisreviewerPK)) {
			return false;
		}
		thesisreviewerPK castOther = (thesisreviewerPK)other;
		return 
				this.reviewerId.equals(castOther.reviewerId)
		&& this.thesisId==castOther.thesisId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.thesisId;
		hash = hash * prime + this.reviewerId.hashCode();

		return hash;
	}

}
