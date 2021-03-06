package com.BTP.actions.supervisor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.BTP.JPA.reviewer;
import com.BTP.services.DisplayReviewersService;


@ParentPackage(value = "custom")
@InterceptorRef("jsonValidationWorkflowStack")
public class EditReviewAction extends ActionSupport{
    
	

	private  reviewer reviewer;
	Map<String, Object> session = ActionContext.getContext().getSession();
	DisplayReviewersService displayReviewersService=new DisplayReviewersService();
	
	
	

	@Action("edit-review")
	public void editReviewer()
	{
		
		System.out.println("called edit review");
		reviewer.getReviewerId().setSupervisor_id((String)session.get("userId"));
		this.displayReviewersService.editReviewer(reviewer);
	}
	
	
	public reviewer getReviewer() {
		return reviewer;
	}
    
	@VisitorFieldValidator(message = "")
	public void setReviewer(reviewer reviewer) {
		this.reviewer = reviewer;
	}
}
