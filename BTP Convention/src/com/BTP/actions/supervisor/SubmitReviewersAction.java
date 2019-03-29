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
	
	
	private String reviewersIndianEmail[];
	private String reviewersAbroadEmail[];
	private int thesis_id;
	SelectReviewerService selectReviewersService=new SelectReviewerService();
	private String emails[];
	
	public void validate()
	{
		HashSet<String> h = new HashSet<String>();
		int count=0;
		for(int i=0;i<reviewersIndianEmail.length;i++)
		{
			if(!(reviewersIndianEmail[i].equals("-1")))
			{
				if(h.contains(reviewersIndianEmail[i]))
				{
					addActionError("You have selected same reviewers");
				}
				h.add(reviewersIndianEmail[i]);
				emails[count]=reviewersIndianEmail[i];
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
		System.out.println(this.reviewersIndianEmail.length);
		this.selectReviewersService.submitIndianReviewers(thesis_id, reviewersIndianEmail);
		this.selectReviewersService.submitAbroadReviewers(thesis_id, reviewersAbroadEmail);
		return SUCCESS;
	}
	

	public String[] getreviewersIndianEmail() {
		return reviewersIndianEmail;
	}

	public void setreviewersIndianEmail(String reviewersIndianEmail[]) {
		this.reviewersIndianEmail = reviewersIndianEmail;
	}


	public int getThesis_id() {
		return thesis_id;
	}


	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}
	public String[] getReviewersAbroadEmail() {
		return reviewersAbroadEmail;
	}
	public void setReviewersAbroadEmail(String reviewersAbroadEmail[]) {
		this.reviewersAbroadEmail = reviewersAbroadEmail;
	}
	
	
	

}
