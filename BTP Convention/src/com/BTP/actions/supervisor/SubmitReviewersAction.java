package com.BTP.actions.supervisor;


import java.util.HashSet;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.BTP.services.SelectReviewerService;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage(value = "custom")
@InterceptorRef("jsonValidationWorkflowStack")
public class SubmitReviewersAction extends ActionSupport{
	
	
	private String reviewersIndianEmail[];
	private String reviewersAbroadEmail[];
	private int thesis_id;
	SelectReviewerService selectReviewersService=new SelectReviewerService();
	private String indianEmails[];
	private String abroadEmails[];
	
	public void validate()
	{
		System.out.println(reviewersIndianEmail.length);
		HashSet<String> h = new HashSet<String>();
		int count=0,count2=0;
		for(int i=0;i<reviewersIndianEmail.length;i++)
		{
			if(!(reviewersIndianEmail[i].equals("-1")))
			{
				if(h.contains(reviewersIndianEmail[i]))
				{
					addActionError("You have selected same reviewers in indian");
				}
				h.add(reviewersIndianEmail[i]);
				indianEmails[count]=reviewersIndianEmail[i];
				count++;
			}
		}
		for(int i=0;i<reviewersAbroadEmail.length;i++)
		{
			if(!(reviewersAbroadEmail[i].equals("-1")))
			{
				if(h.contains(reviewersAbroadEmail[i]))
				{
					addActionError("You have selected same reviewers in abroad");
				}
				h.add(reviewersAbroadEmail[i]);
				abroadEmails[count]=reviewersAbroadEmail[i];
				count2++;
			}
		}
		if(count<3 || count2<3)
		{
			addActionError("Please select minimum 3 reviewers");
		}
	}
	@Action("submit-reviewers")
	public void execut()
	{
		System.out.println(this.reviewersIndianEmail.length);
		this.selectReviewersService.submitIndianReviewers(thesis_id, indianEmails);
		this.selectReviewersService.submitAbroadReviewers(thesis_id, abroadEmails);
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
