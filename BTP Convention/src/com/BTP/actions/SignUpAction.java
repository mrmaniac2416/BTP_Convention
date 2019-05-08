package com.BTP.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;

import com.BTP.JPA.users;
import com.BTP.services.EmailService;
import com.BTP.services.LoginService;
import com.opensymphony.xwork2.ActionSupport;


@InterceptorRef("defaultStack")
public class SignUpAction extends ActionSupport{
	
	private List<users> supervisors;
	LoginService loginService=new LoginService();
	
	
	public String execute()
	{
		System.out.println("in sign up action");
		this.setSupervisors(this.loginService.getSupervisors());
		return SUCCESS;
	}

	public List<users> getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(List<users> supervisors) {
		this.supervisors = supervisors;
	}

	
}