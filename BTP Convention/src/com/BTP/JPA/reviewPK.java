package com.BTP.JPA;

import java.io.Serializable;

import javax.persistence.Embeddable;



@Embeddable
public class reviewPK implements Serializable{
	
	private int thesis_id;
	private String email_id;
	
	public reviewPK() {
		
	}

	public int getThesis_id() {
		return thesis_id;
	}

	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof reviewPK)) {
			return false;
		}
		reviewPK castOther = (reviewPK)other;
		return 
			this.thesis_id==castOther.thesis_id
			&& this.email_id.equals(castOther.email_id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.thesis_id;
		hash = hash * prime + this.email_id.hashCode();
		
		return hash;
	}
	
	
}
