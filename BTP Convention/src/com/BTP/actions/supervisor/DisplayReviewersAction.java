package com.BTP.actions.supervisor;

import java.util.List;
import java.util.Map;

import com.BTP.JPA.reviewer;
import com.BTP.services.DisplayReviewersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.ConversionRule;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

public class DisplayReviewersAction extends ActionSupport{
	
	private List<reviewer> reviewers;
	Map<String, Object> session = ActionContext.getContext().getSession();
	DisplayReviewersService displayReviewersService=new DisplayReviewersService();
	
	
	
	public String execute()
	{
		String userId=(String)session.get("userId");
		reviewers=this.displayReviewersService.fetchReviewers(userId);
		return SUCCESS;
	}


	public List<reviewer> getReviewers() {
		return reviewers;
	}


	public void setReviewers(List<reviewer> reviewers) {
		this.reviewers = reviewers;
	}


	
	
	

}
