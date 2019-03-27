package com.BTP.actions.supervisor;

import com.BTP.services.SelectReviewerService;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitReviewers extends ActionSupport{
	
	
	private String reviewersEmail[];
	private int thesis_id;
	SelectReviewerService selectReviewersService=new SelectReviewerService();
	
	
	public String execute()
	{
		System.out.println(this.reviewersEmail.length);
		System.out.println(this.thesis_id);
		this.selectReviewersService.submitReviewers(thesis_id, reviewersEmail);
		return SUCCESS;
	}
	

	public String[] getReviewersEmail() {
		return reviewersEmail;
	}

	public void setReviewersEmail(String reviewersEmail[]) {
		this.reviewersEmail = reviewersEmail;
	}


	public int getThesis_id() {
		return thesis_id;
	}


	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}
	
	
	

}
