package com.BTP.actions.dean;

import java.util.Map;

import org.apache.struts2.convention.annotation.Result;

import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", location="dean-accepted-reviewer",type="redirectAction")
public class GenerateUserAction extends ActionSupport{
	
	private String email;
	Map<String, Object> session = ActionContext.getContext().getSession();
	EmailService emailService = new EmailService();
	
	public String execute()
	{
		int thesisId = (int)session.get("thesisId");
		emailService.generateUser(thesisId, email);
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
