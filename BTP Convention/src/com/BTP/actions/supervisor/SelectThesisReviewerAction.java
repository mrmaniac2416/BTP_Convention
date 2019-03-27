package com.BTP.actions.supervisor;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.BTP.JPA.reviewer;
import com.BTP.services.DisplayReviewersService;

public class SelectThesisReviewerAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	private List<reviewer> reviewerList;
	DisplayReviewersService displayReviewer = new DisplayReviewersService();
	
	public String execute()
	{
		String userId=(String)session.get("userId");
		setReviewerList(this.displayReviewer.fetchReviewers(userId));
		return SUCCESS;
	}

	public List<reviewer> getReviewerList() {
		return reviewerList;
	}

	public void setReviewerList(List<reviewer> reviewerList) {
		this.reviewerList = reviewerList;
	}

}
