package com.BTP.JPA;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class reviewerPK implements Serializable{


	private String email_id;
	private String supervisor_id;

	public reviewerPK() {

	}




	public String getEmail_id() {
		return email_id;
	}




	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}




	public String getSupervisor_id() {
		return supervisor_id;
	}




	public void setSupervisor_id(String supervisor_id) {
		this.supervisor_id = supervisor_id;
	}




	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof reviewerPK)) {
			return false;
		}
		reviewerPK castOther = (reviewerPK)other;
		return 
				this.supervisor_id.equals(castOther.supervisor_id)
		&& this.email_id.equals(castOther.email_id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.supervisor_id.hashCode();
		hash = hash * prime + this.email_id.hashCode();

		return hash;
	}


}