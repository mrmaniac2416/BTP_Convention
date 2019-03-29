package com.BTP.actions.supervisor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.BTP.JPA.reviewer;
import com.BTP.services.DisplayReviewersService;


@ParentPackage(value="custom")
public class SelectThesisReviewerAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	private List<reviewer> reviewerIndianList;
	private List<reviewer> reviewerAbroadList;
	private List<String> reviewerIndianEmails=new ArrayList<>();
	private List<String> reviewerAbroadEmails=new ArrayList<>();
	public List<String> getReviewerIndianEmails() {
		return reviewerIndianEmails;
	}

	public void setReviewerIndianEmails(List<String> reviewerIndianEmails) {
		this.reviewerIndianEmails = reviewerIndianEmails;
	}

	private int thesis_id;
	private reviewer reviewerFromEmail;
	private String email;
	DisplayReviewersService displayReviewer = new DisplayReviewersService();
	String userId=(String)session.get("userId");
	
	public String execute()
	{
		
		setreviewerIndianList(this.displayReviewer.fetchIndianReviewers(userId));
		setReviewerAbroadList(this.displayReviewer.fetchAbroadReviewers(userId));
		return SUCCESS;
	}
	
	 @Actions( {
		    @Action(value = "get-reviewer-emails", results = {
		      @Result(name = "success", type = "json")
		    })
		  })
	public String fetchReviewerEmails()
	{
		 setreviewerIndianList(this.displayReviewer.fetchIndianReviewers(userId));
		 setReviewerAbroadList(this.displayReviewer.fetchAbroadReviewers(userId));
		 for(reviewer  reviewer: reviewerIndianList)
		{
			reviewerIndianEmails.add(reviewer.getReviewerId().getEmail());
		}
		 for(reviewer  reviewer: reviewerAbroadList)
			{
				reviewerAbroadEmails.add(reviewer.getReviewerId().getEmail());
			}
		return SUCCESS;
	}
	 
	 @Actions( {
		    @Action(value = "get-reviewer-from-email", results = {
		      @Result(name = "success", type = "json")
		    })
		  })
	 public String fetchReviewerFromEmail()
	 {
		 setreviewerIndianList(this.displayReviewer.fetchReviewers(userId));
		 for(reviewer  reviewer: reviewerIndianList)
			{
				if(reviewer.getReviewerId().getEmail().equals(getEmail()))
				{
					this.setReviewerFromEmail(reviewer);
					break;
				}
			}
//		 System.out.println(reviewerFromEmail.getName() + " " + reviewerFromEmail.getReviewerId().getEmail_id());
		  return SUCCESS;
	 }

	public List<reviewer> getreviewerIndianList() {
		return reviewerIndianList;
	}

	public void setreviewerIndianList(List<reviewer> reviewerIndianList) {
		this.reviewerIndianList = reviewerIndianList;
	}

	public int getThesis_id() {
		return thesis_id;
	}

	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}

	public reviewer getReviewerFromEmail() {
		return reviewerFromEmail;
	}

	public void setReviewerFromEmail(reviewer reviewerFromEmail) {
		this.reviewerFromEmail = reviewerFromEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<reviewer> getReviewerAbroadList() {
		return reviewerAbroadList;
	}

	public void setReviewerAbroadList(List<reviewer> reviewerAbroadList) {
		this.reviewerAbroadList = reviewerAbroadList;
	}

	public List<String> getReviewerAbroadEmails() {
		return reviewerAbroadEmails;
	}

	public void setReviewerAbroadEmails(List<String> reviewerAbroadEmails) {
		this.reviewerAbroadEmails = reviewerAbroadEmails;
	}

}
