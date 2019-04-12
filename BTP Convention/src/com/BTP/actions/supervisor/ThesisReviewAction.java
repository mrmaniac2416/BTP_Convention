package com.BTP.actions.supervisor;

import java.util.List;
import java.util.Map;

import com.BTP.services.ArchivesThesisService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ThesisReviewAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	private List<Object[]> reviewedThesis;
	ArchivesThesisService review = new ArchivesThesisService();
	
	public String execute()
	{
		String userId = (String) session.get("userId");
		setReviewedThesis(review.reviewedThesis(userId));
		System.out.println(reviewedThesis);
		return SUCCESS;
	}

	public List<Object[]> getReviewedThesis() {
		return reviewedThesis;
	}

	public void setReviewedThesis(List<Object[]> reviewedThesis) {
		this.reviewedThesis = reviewedThesis;
	}

	
	

}
