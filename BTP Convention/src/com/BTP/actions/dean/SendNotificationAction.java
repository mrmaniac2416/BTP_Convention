package com.BTP.actions.dean;

import java.util.Map;

import org.apache.struts2.convention.annotation.Result;

import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", location="thesis-reviewing",type="redirectAction")
public class SendNotificationAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	private String email;
	EmailService emailService = new EmailService();
	public String execute()
	{
		int thesisId = (int)session.get("thesisId");
		emailService.sendNotification(thesisId, email);
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
