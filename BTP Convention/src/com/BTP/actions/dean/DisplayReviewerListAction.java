package com.BTP.actions.dean;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayReviewerListAction extends ActionSupport implements SessionAware{
	
	private int thesisId;
	private Object[] thesisDetails;
	private List<Object[]> indianReviewers;
	private List<Object[]> abroadReviewers;
	DeanService deanService = new DeanService();
	private SessionMap<String,Object> sessionMap;
	
	public String execute()
	{
		
		System.out.println(thesisId);
		sessionMap.put("thesisId",thesisId);
		setThesisDetails(deanService.ThesisDetails(thesisId));
		setIndianReviewers(deanService.fetchIndianReviewers(thesisId));
		setAbroadReviewers(deanService.fetchAbroadReviewers(thesisId));
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







	public int getThesisId() {
		return thesisId;
	}







	public void setThesisId(int thesis_id) {
		this.thesisId = thesis_id;
	}







	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.sessionMap=(SessionMap<String, Object>) session;
		
	}







	public Object[] getThesisDetails() {
		return thesisDetails;
	}







	public void setThesisDetails(Object[] thesisDetails) {
		this.thesisDetails = thesisDetails;
	}

}
