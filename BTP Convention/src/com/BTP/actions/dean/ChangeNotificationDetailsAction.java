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
public class ChangeNotificationDetailsAction extends ActionSupport{

	
	private String notificationMailBody;
	private String notificationMailSubject;
	private EmailService emailService=new EmailService();
	
	
	
	@Action("change-notification-details")
	public void changeDetails()
	{
		this.emailService.updateNotificationMailDetails(this.notificationMailBody, this.notificationMailSubject);
	}



	public String getNotificationMailBody() {
		return notificationMailBody;
	}


	@RequiredStringValidator(message="Enter notification mail body!")
	public void setNotificationMailBody(String notificationMailBody) {
		this.notificationMailBody = notificationMailBody;
	}



	public String getNotificationMailSubject() {
		return notificationMailSubject;
	}


	@RequiredStringValidator(message="Enter notification mail subject!")
	public void setNotificationMailSubject(String notificationMailSubject) {
		this.notificationMailSubject = notificationMailSubject;
	}



	

	
}
