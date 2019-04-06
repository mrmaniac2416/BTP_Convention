package com.BTP.actions.dean;

import java.util.List;
import java.util.Map;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeanAcceptedReviewerAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	private List<Object[]> thesisDetails;
	private List<Object[]> indianReviewers;
	private List<Object[]> abroadReviewers;
	DeanService deanService = new DeanService();
	
	public String execute()
	{
		int thesisId=(int)session.get("thesisId");
		setThesisDetails(deanService.ThesisDetails(thesisId));
		setIndianReviewers(deanService.fetchAcceptedIndianReviewers(thesisId));
		setAbroadReviewers(deanService.fetchAcceptedAbroadReviewers(thesisId));
		return SUCCESS;
	}

	public List<Object[]> getThesisDetails() {
		return thesisDetails;
	}

	public void setThesisDetails(List<Object[]> thesisDetails) {
		this.thesisDetails = thesisDetails;
	}

	public List<Object[]> getIndianReviewers() {
		return indianReviewers;
	}

	public void setIndianReviewers(List<Object[]> indianReviewers) {
		this.indianReviewers = indianReviewers;
	}

	public List<Object[]> getAbroadReviewers() {
		return abroadReviewers;
	}

	public void setAbroadReviewers(List<Object[]> abroadReviewers) {
		this.abroadReviewers = abroadReviewers;
	}
	
	

}
