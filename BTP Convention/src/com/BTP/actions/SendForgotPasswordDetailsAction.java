package com.BTP.actions;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;


@ParentPackage(value = "custom2")
@InterceptorRef("jsonValidationWorkflowStack")
@Results({
	@Result(name = "success", type = "json"),
	@Result(name="error",type="json",params= {"errorCode","400"})
})
public class SendForgotPasswordDetailsAction extends ActionSupport{
	
	private String email;
	private EmailService emailService=new EmailService();
	
	public void validate()
	{
		if(!emailService.emailExists(email) && !email.isEmpty())
			addFieldError("email","The specified email is not registered!");
	}
	
	public String execute()
	{
		
		return emailService.sendForgotPasswordEmail(email);
	}

	public String getEmail() {
		return email;
	}
    
	
	@RequiredStringValidator(message = "Enter Email.")
    @EmailValidator(message = "Enter a valid E-mail address." )
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
