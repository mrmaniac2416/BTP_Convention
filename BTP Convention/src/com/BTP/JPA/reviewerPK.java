package com.BTP.JPA;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Embeddable
public class reviewerPK implements Serializable{


	@Column(name="email_id")
	private String email;
	private String supervisor_id;

	public reviewerPK() {

	}




	public String getEmail() {
		return email;
	}




	@RequiredStringValidator(message = "Enter Email.")
    @EmailValidator(message = "Enter a valid E-mail address." )
	public void setEmail(String email_id) {
		this.email = email_id;
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
		&& this.email.equals(castOther.email);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.supervisor_id.hashCode();
		hash = hash * prime + this.email.hashCode();

		return hash;
	}


}