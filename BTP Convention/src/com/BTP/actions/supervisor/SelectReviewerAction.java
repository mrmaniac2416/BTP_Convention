package com.BTP.actions.supervisor;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.BTP.services.SelectReviewerService;

public class SelectReviewerAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	private List<Object[]> acceptedThesis;
	SelectReviewerService selectReviewerService = new SelectReviewerService();
	public String execute()
	{
		String userId=(String)session.get("userId");
		this.setAcceptedThesis(selectReviewerService.selectReviewerDashboard(userId));
		
		return "success" ;
		
		
	}
	public List<Object[]> getAcceptedThesis() {
		return acceptedThesis;
	}
	public void setAcceptedThesis(List<Object[]> acceptedThesis) {
		this.acceptedThesis = acceptedThesis;
	}

}
