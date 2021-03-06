package com.BTP.actions.reviewer;

import java.util.List;
import java.util.Map;

import com.BTP.services.ReviewerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PendingReviewsAction extends ActionSupport{
	
	private List<Object[]> pendingReviewsDetails;
	ReviewerService reviewerService=new ReviewerService();
	private String reviewerId;

	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String execute()
	{
		
		System.out.println("in action");
		reviewerId=(String)session.get("userId");
		this.pendingReviewsDetails=reviewerService.generatePendingReviews(reviewerId);
		System.out.println(this.pendingReviewsDetails.size());
		return SUCCESS;
	}
	
	
	public List<Object[]> getPendingReviewsDetails() {
		return pendingReviewsDetails;
	}

	public void setPendingReviewsDetails(List<Object[]> pendingReviewsDetails) {
		this.pendingReviewsDetails = pendingReviewsDetails;
	}

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}




}
