package com.BTP.actions.dean;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.BTP.JPA.deanaccountdetails;
import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@ParentPackage(value = "custom3")
@InterceptorRef("jsonValidationWorkflowStack")
public class ChangeDetailsAction extends ActionSupport{
	
	
	private String email;
	private String password;
	private EmailService emailService=new EmailService();

	
	
	public void validate()
	{
		
		
		
		if(!emailService.authenticate(email, password))
		{
			System.out.println("not correct");
			addActionError("Invalid email/password");
		}
	}
	
	
	@Action("change-details")
	public void changeDetails()
	{
		this.emailService.updateDeanEmailDetails(email,password);
	}


	public String getEmail() {
		return email;
	}

	@EmailValidator(message = "Enter a valid E-mail address." )
	@RequiredStringValidator(message="Enter your email!")
	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	@RequiredStringValidator(message="Enter your password!")
	public void setPassword(String password) {
		this.password = password;
	}
    
	
	

}
