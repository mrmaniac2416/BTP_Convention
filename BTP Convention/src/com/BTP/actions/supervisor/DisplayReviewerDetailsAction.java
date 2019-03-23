package com.BTP.actions.supervisor;
import com.BTP.JPA.reviewer;
import com.BTP.services.DisplayReviewersService;

import org.apache.struts2.convention.annotation.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.ConversionRule;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;


public class DisplayReviewerDetailsAction extends ActionSupport{
	
	
	
	public String getReviewer_supervisor_id() {
		return reviewer_supervisor_id;
	}


	public void setReviewer_supervisor_id(String reviewer_supervisor_id) {
		this.reviewer_supervisor_id = reviewer_supervisor_id;
	}


	private String reviewer_email_id;
	private String reviewer_supervisor_id;
	private reviewer reviewer;
	DisplayReviewersService displayReviewerService=new DisplayReviewersService();
	public String execute()
	{
		setReviewer(this.displayReviewerService.fetchReviewer(reviewer_supervisor_id, reviewer_email_id));
		return SUCCESS;
	}


	public String getReviewer_email_id() {
		return reviewer_email_id;
	}


	public void setReviewer_email_id(String reviewer_email_id) {
		this.reviewer_email_id = reviewer_email_id;
	}


	public reviewer getReviewer() {
		return reviewer;
	}


	public void setReviewer(reviewer reviewer) {
		this.reviewer = reviewer;
	}


	


	

	

}
