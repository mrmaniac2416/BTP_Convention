package com.BTP.actions.dean;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="custom3")
public class SendNotificationMailAction extends ActionSupport{
	private String subject;
	private String body;
	Map<String, Object> session = ActionContext.getContext().getSession();

	private String email;
	
	EmailService emailService = new EmailService();
	
	 @Actions( {
		    @Action(value = "send-notification-mail", results = {
		      @Result(name = "success", type = "json"),
		      @Result(name="error",type="json",params= {"errorCode","400"})
		    })
		  })
	public String execute() {
         int thesisId=(int)session.get("thesisId");
		 System.out.println("in send notification mail");
		 return emailService.sendNotification(thesisId, email, body, subject);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
