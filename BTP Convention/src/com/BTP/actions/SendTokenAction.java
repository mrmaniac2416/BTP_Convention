package com.BTP.actions;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.BTP.services.LoginService;
import com.opensymphony.xwork2.ActionSupport;


@InterceptorRef("defaultStack")
@Results({
	@Result(name = "success",location="reset-password.jsp")
})
public class SendTokenAction extends ActionSupport{
	private String token;
	private String email;
	
	LoginService loginService=new LoginService();
	
	
	public String execute()
	{
		return this.loginService.checkResetToken(token, email);
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
