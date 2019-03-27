package com.BTP.actions.supervisor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.BTP.JPA.reviewer;
import com.BTP.services.DisplayReviewersService;


@ParentPackage(value="custom")
public class SelectThesisReviewerAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	private List<reviewer> reviewerList;
	private List<String> reviewerEmails=new ArrayList<>();
	private int thesis_id;
	DisplayReviewersService displayReviewer = new DisplayReviewersService();
	String userId=(String)session.get("userId");
	
	public String execute()
	{
		
		setReviewerList(this.displayReviewer.fetchReviewers(userId));
		return SUCCESS;
	}
	
	 @Actions( {
		    @Action(value = "get-reviewer-emails", results = {
		      @Result(name = "success", type = "json")
		    })
		  })
	public String fetchReviewerEmails()
	{
		 setReviewerList(this.displayReviewer.fetchReviewers(userId));
		 for(reviewer  reviewer: reviewerList)
		{
			reviewerEmails.add(reviewer.getReviewerId().getEmail_id());
		}
		return SUCCESS;
	}

	public List<String> getReviewerEmails() {
		return reviewerEmails;
	}

	public void setReviewerEmails(List<String> reviewerEmails) {
		this.reviewerEmails = reviewerEmails;
	}

	public List<reviewer> getReviewerList() {
		return reviewerList;
	}

	public void setReviewerList(List<reviewer> reviewerList) {
		this.reviewerList = reviewerList;
	}

	public int getThesis_id() {
		return thesis_id;
	}

	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}

}
