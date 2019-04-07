package com.BTP.actions.dean;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.BTP.JPA.deanaccountdetails;
import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@ParentPackage(value = "custom3")
@InterceptorRef("jsonValidationWorkflowStack")
public class ChangeDetailsAction extends ActionSupport{
	
	
	private deanaccountdetails deanaccountdetails;
	private EmailService emailService=new EmailService();

	public deanaccountdetails getDeanaccountdetails() {
		return deanaccountdetails;
	}
	
	public void validate()
	{
		String email=this.deanaccountdetails.getEmail();
		String password=this.deanaccountdetails.getPassword();
		
		
		if(!emailService.authenticate(email, password))
		{
			System.out.println("not correct");
			addActionError("Invalid email/password");
		}
	}
	
	
	@Action("change-details")
	public void changeDetails()
	{
		this.emailService.updateDeanEmailDetails(deanaccountdetails);
	}
    
	
	@VisitorFieldValidator(message = "")
	public void setDeanaccountdetails(deanaccountdetails deanaccountdetails) {
		this.deanaccountdetails = deanaccountdetails;
	}

}
