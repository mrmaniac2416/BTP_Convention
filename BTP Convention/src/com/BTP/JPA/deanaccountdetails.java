package com.BTP.JPA;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
public class deanaccountdetails {
	
	@Id
	private String email;
	private String password;
	public String getPassword() {
		return password;
	}
	
	@RequiredStringValidator(message="Enter your password!")
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	
	@EmailValidator(message = "Enter a valid E-mail address." )
	@RequiredStringValidator(message="Enter your email!")
	public void setEmail(String email) {
		this.email = email;
	}

}
