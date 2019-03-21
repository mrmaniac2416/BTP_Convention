package com.BTP.actions.supervisor;



import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.BTP.services.AcceptThesisService;


public class AcceptThesisAction extends ActionSupport {

	Map<String, Object> session = ActionContext.getContext().getSession();
	private List<Object[]> acceptedThesis;
	AcceptThesisService acceptThesisService=new AcceptThesisService();
	private int thesisId;
	public String execute()
	{
		String userId=(String)session.get("userId");
		this.acceptedThesis=acceptThesisService.acceptThesisDashboard(userId);
		
		return SUCCESS ;
		
		
	}
	public List<Object[]> getAcceptedThesis() {
		return acceptedThesis;
	}
	public void setAcceptedThesis(List<Object[]> acceptedThesis) {
		this.acceptedThesis = acceptedThesis;
	}
	
	@Action(value="accepted-thesis",results = {
		    @Result(name="success", location="accept-thesis.jsp")
		})
	public String acceptThesis()
	{
	    this.acceptThesisService.acceptThesis(thesisId);
	    String userId=(String)session.get("userId");
		this.acceptedThesis=acceptThesisService.acceptThesisDashboard(userId);
	    return SUCCESS;
	}
	public int getThesisId() {
		return thesisId;
	}
	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}

	

	
}
