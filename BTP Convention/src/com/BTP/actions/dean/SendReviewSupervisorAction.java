package com.BTP.actions.dean;

import java.util.Map;

import org.apache.struts2.convention.annotation.Result;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", location="display-reviewed",type="redirectAction")
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

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}
	

}
