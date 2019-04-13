package com.BTP.actions;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.BTP.services.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@ParentPackage(value = "custom2")
@InterceptorRef("jsonValidationWorkflowStack")
@Results({
	@Result(name = "success", type = "json"),
	@Result(name="error",type="json",params= {"errorCode","400"})
})
public class ResetPasswordAction extends ActionSupport{
	
	private String email;
	private String password;
	private String confirmPassword;
	private String token;
	LoginService loginService=new LoginService();
	
	public void validate()
	{
		if(!password.equals(confirmPassword))
		{
			addFieldError("confirmPassword","Both the password do not match!");
		}
	}
	
	
	
	
	public String execute()
	{
		
		return this.loginService.updatePassword(password, email,token);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	@RequiredStringValidator(message = "Enter password.")
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	@RequiredStringValidator(message = "Enter password again.")
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}




	public String getToken() {
		return token;
	}




	public void setToken(String token) {
		this.token = token;
	}

}
