package com.BTP.actions.reviewer;

import com.opensymphony.xwork2.ActionSupport;

public class PendingReviewDetailsAction extends ActionSupport{
	
	private Object[] pendingReview;
	
	
	public String execute()
	{
		System.out.println(pendingReview.length);
		return SUCCESS;
	}
	
	
	

	public Object[] getPendingReview() {
		return pendingReview;
	}

	public void setPendingReview(Object[] pendingReview) {
		this.pendingReview = pendingReview;
	}


}
