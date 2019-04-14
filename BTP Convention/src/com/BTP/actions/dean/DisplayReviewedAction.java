package com.BTP.actions.dean;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayReviewedAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	private Object[] thesisDetails;
	private List<Object[]> indianReviewers;
	private List<Object[]> abroadReviewers;
	DeanService deanService = new DeanService();
	
	public String execute()
	{
		int thesisId=(int)session.get("thesisId");
		setThesisDetails(deanService.ThesisDetails(thesisId));
		setIndianReviewers(deanService.fetchReviewedIndianReviewers(thesisId));
		setAbroadReviewers(deanService.fetchReviewedAbroadReviewers(thesisId));
		return SUCCESS;
	}
	
	@Action("archive-reviewed")
	public String archiveExecute()
	{
		int thesisId=(int)session.get("thesisId");
		setThesisDetails(deanService.ThesisDetails(thesisId));
		setIndianReviewers(deanService.fetchReviewedIndianReviewers(thesisId));
		setAbroadReviewers(deanService.fetchReviewedAbroadReviewers(thesisId));
		return SUCCESS;
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




	public Object[] getThesisDetails() {
		return thesisDetails;
	}




	public void setThesisDetails(Object[] thesisDetails) {
		this.thesisDetails = thesisDetails;
	}




	
	
	

}
