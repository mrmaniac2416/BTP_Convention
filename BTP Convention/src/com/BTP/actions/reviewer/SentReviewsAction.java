package com.BTP.actions.reviewer;

import java.util.List;
import java.util.Map;

import com.BTP.services.ReviewerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SentReviewsAction extends ActionSupport{
	
	private List<Object[]> sentReviewsDetails;
	public List<Object[]> getSentReviewsDetails() {
		return sentReviewsDetails;
	}



	public void setSentReviewsDetails(List<Object[]> sentReviewsDetails) {
		this.sentReviewsDetails = sentReviewsDetails;
	}

	ReviewerService reviewerService=new ReviewerService();
	private String reviewerId;

	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String execute()
	{
		
		System.out.println("in send review action");
		reviewerId=(String)session.get("userId");
		this.sentReviewsDetails=reviewerService.generateSentReviews(reviewerId);
		System.out.println(this.sentReviewsDetails.size());
		return SUCCESS;
	}
	
	

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}



}
