package com.BTP.actions.dean;

import java.util.Map;

import org.apache.struts2.convention.annotation.Result;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", location="display-reviewer-list",type="redirectAction", params= {"thesisId","${thesisId}"})
public class AcceptReviewerAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	private String reviewerEmail;
	private int thesisId;
	DeanService deanService = new DeanService();
	
	public String execute()
	{
//		int thesisId = (int)session.get("thesisId");
		deanService.acceptReviewer(thesisId, reviewerEmail);
		return SUCCESS;
	}

	public String getReviewerEmail() {
		return reviewerEmail;
	}

	public void setReviewerEmail(String reviewerEmail) {
		this.reviewerEmail = reviewerEmail;
	}

	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}

}
