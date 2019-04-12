package com.BTP.actions.dean;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.BTP.JPA.deanaccountdetails;
import com.BTP.services.EmailService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;


@ParentPackage(value = "custom3")
@InterceptorRef("jsonValidationWorkflowStack")
public class ChangeInvitationDetailsAction extends ActionSupport{

	
	private String invitationMailBody;
	private String invitationMailSubject;
	private EmailService emailService=new EmailService();
	
	
	
	@Action("change-invitation-details")
	public void changeDetails()
	{
		this.emailService.updateInvitationMailDetails(invitationMailBody, invitationMailSubject);
	}



	public String getInvitationMailBody() {
		return invitationMailBody;
	}


	@RequiredStringValidator(message="Enter invitation mail body!")
	public void setInvitationMailBody(String invitationMailBody) {
		this.invitationMailBody = invitationMailBody;
	}



	public String getInvitationMailSubject() {
		return invitationMailSubject;
	}


	@RequiredStringValidator(message="Enter invitation mail subject!")
	public void setInvitationMailSubject(String invitationMailSubject) {
		this.invitationMailSubject = invitationMailSubject;
	}
	

	
}
