package com.BTP.actions.supervisor;

import java.util.HashSet;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.BTP.services.SelectReviewerService;
import com.opensymphony.xwork2.ActionSupport;

@Results({
@Result(name="success",location="select-reviewer",type="redirect"),
@Result(name="input",location="select-reviewer",type="redirect")})

public class SubmitReviewersAction extends ActionSupport{
	
	
	private String reviewersEmail[];
	private int thesis_id;
	SelectReviewerService selectReviewersService=new SelectReviewerService();
	private String emails[];
	
	public void validate()
	{
		HashSet<String> h = new HashSet<String>();
		int count=0;
		for(int i=0;i<reviewersEmail.length;i++)
		{
			if(!(reviewersEmail[i].equals("-1")))
			{
				if(h.contains(reviewersEmail[i]))
				{
					addActionError("You have selected same reviewers");
				}
				h.add(reviewersEmail[i]);
				emails[count]=reviewersEmail[i];
				count++;
			}
		}
		if(count<3)
		{
			addActionError("Please select minimum 3 reviewers");
		}
	}
	public String execute()
	{
		System.out.println(this.reviewersEmail.length);
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
