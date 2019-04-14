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
public class GenerateUserAction extends ActionSupport{
	
	private String email;
	Map<String, Object> session = ActionContext.getContext().getSession();
	EmailService emailService = new EmailService();
	
	
	
	 @Actions( {
		    @Action(value = "generate-user", results = {
		      @Result(name = "success", type = "json"),
		      @Result(name="error",type="json",params= {"errorCode","400"})
		    })
		  })
	public String execute()
	{
		int thesisId = (int)session.get("thesisId");
		return emailService.generateUser(thesisId, email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
