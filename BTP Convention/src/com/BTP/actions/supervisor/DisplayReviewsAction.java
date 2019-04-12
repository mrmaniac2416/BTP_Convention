package com.BTP.actions.supervisor;

import java.util.List;

import com.BTP.services.ArchivesThesisService;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayReviewsAction extends ActionSupport{
	
	private int thesisId;
	ArchivesThesisService review = new ArchivesThesisService();
	private List<Object[]> reviewers;
	public String execute()
	{
		setReviewers(review.thesisReviews(thesisId));
		return SUCCESS;
	}

	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}

	public List<Object[]> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<Object[]> reviewers) {
		this.reviewers = reviewers;
	}

}
