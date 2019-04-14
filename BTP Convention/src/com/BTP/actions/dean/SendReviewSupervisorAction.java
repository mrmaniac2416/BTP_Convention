package com.BTP.actions.dean;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Results({
@Result(name="success", location="display-reviewed",type="redirectAction"),
@Result(name="archiveSuccess", location="archive-reviewed",type="redirectAction")})

public class SendReviewSupervisorAction extends ActionSupport{
	
	private String reviewerId;
	Map<String, Object> session = ActionContext.getContext().getSession();
	DeanService deanService = new DeanService();
	
	public String execute()
	{
		int thesisId = (int)session.get("thesisId");
		deanService.sendToSupervisor(thesisId, reviewerId);
		return SUCCESS;
	}
	
	@Action("archive-send-review-supervisor")
	public String archiveExecute()
	{
		int thesisId = (int)session.get("thesisId");
		deanService.sendToSupervisor(thesisId, reviewerId);
		return "archiveSuccess";
	}

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}
	

}
