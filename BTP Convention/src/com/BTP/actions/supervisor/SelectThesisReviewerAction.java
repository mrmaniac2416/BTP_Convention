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
	private int thesis_id;
	DisplayReviewersService displayReviewer = new DisplayReviewersService();
	
	
	public String execute()
	{
		System.out.println("in select thesis action");
		String userId=(String)session.get("userId");
		setReviewerList(this.displayReviewer.fetchReviewers(userId));
		for(reviewer reviewer:reviewerList)
			System.out.println(reviewer.getName());
		return SUCCESS;
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
