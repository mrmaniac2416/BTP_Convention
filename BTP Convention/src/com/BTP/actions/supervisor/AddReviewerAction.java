package com.BTP.actions.supervisor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import com.BTP.JPA.reviewer;
import com.BTP.services.DisplayReviewersService;

public class AddReviewerAction extends ActionSupport{
       
	
	private reviewer reviewer;
	Map<String, Object> session = ActionContext.getContext().getSession();
	DisplayReviewersService displayReviewersService=new DisplayReviewersService();
	
	@Action("add-reviewer")
	public void addReviewer()
	{
		
		reviewer.getReviewerId().setSupervisor_id((String)session.get("userId"));
		this.displayReviewersService.addReviewer(reviewer);
		
	}
	

	public reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(reviewer reviewer) {
		this.reviewer = reviewer;
	}
	
	
	
}
