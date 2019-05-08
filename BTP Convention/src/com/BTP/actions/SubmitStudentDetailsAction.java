package com.BTP.actions;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@ParentPackage(value = "custom2")
@InterceptorRef("jsonValidationWorkflowStack")
@Results({
	@Result(name = "success", type = "json"),
	@Result(name="error",type="json",params= {"errorCode","400"})
})
public class SubmitStudentDetailsAction extends ActionSupport{

	
	private String email;
	private String password;
	private String repassword;
	private String supervisor;
	private String researchArea;
	private String name;
	
	private EmailService emailService=new EmailService();
	
	
	public void validate()
	{
		
		if(this.emailService.emailExists(email))
		{
			addFieldError("email","The entered email is already registered");
		}
	}
	
	public String execute()
	{
		
		this.emailService.sendSignUpEmail(email, password, researchArea, supervisor, name);
		return SUCCESS;
	}
	
	
	public String getEmail() {
		return email;
	}
	@RequiredStringValidator(message = "Enter your email.")
	@EmailValidator(message = "Enter a valid E-mail address." )
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	@RequiredStringValidator(message = "Enter a password.")
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	
	@RequiredStringValidator(message = "Enter password again.")
	@FieldExpressionValidator(message="Both passwords don't match!", expression="(password==repassword)" )
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getSupervisor() {
		return supervisor;
	}
	@FieldExpressionValidator(message="Enter a supervisor", expression="(supervisor!='-1')" )
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getResearchArea() {
		return researchArea;
	}
	
	@RequiredStringValidator(message = "Enter a research area.")
	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}

	public String getName() {
		return name;
	}
    
	@RequiredStringValidator(message = "Enter your name.")
	public void setName(String name) {
		this.name = name;
	}
}
