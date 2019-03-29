package com.BTP.actions.supervisor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.BTP.JPA.reviewer;
import com.BTP.services.DisplayReviewersService;


@ParentPackage(value = "custom")
@InterceptorRef("jsonValidationWorkflowStack")
public class AddReviewerAction extends ActionSupport{
       
	
	private reviewer reviewer;
	Map<String, Object> session = ActionContext.getContext().getSession();
	DisplayReviewersService displayReviewersService=new DisplayReviewersService();
	
	
	
	
	public void validate()
	{
		String email=reviewer.getReviewerId().getEmail();
		String supervisorId=(String)session.get("userId");
		reviewer matchedReviewer=this.displayReviewersService.fetchReviewer(supervisorId, email);
		
		if(matchedReviewer!=null)
		{
			addFieldError("reviewer.reviewerId.email","Reviewer with the email alreadys exists!");
		}
	}
	
	@Action("add-reviewer")
	public void addReviewer()
	{
		
		reviewer.getReviewerId().setSupervisor_id((String)session.get("userId"));
		this.displayReviewersService.addReviewer(reviewer);
		
	}
	

	public reviewer getReviewer() {
		return reviewer;
	}
    
	
	@VisitorFieldValidator(message = "")
	public void setReviewer(reviewer reviewer) {
		this.reviewer = reviewer;
	}
	
	
	
}
