package com.BTP.actions.dean;

import java.util.List;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayReviewerListAction extends ActionSupport{
	
	private int thesis_id;
	private List<Object[]> thesisDetails;
	private List<Object[]> indianReviewers;
	private List<Object[]> abroadReviewers;
	DeanService deanService = new DeanService();
	
	
	public String execute()
	{
		
		System.out.println(thesis_id);
		setThesisDetails(deanService.ThesisDetails(thesis_id));
		setIndianReviewers(deanService.fetchIndianReviewers(thesis_id));
		setAbroadReviewers(deanService.fetchAbroadReviewers(thesis_id));
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







	public int getThesis_id() {
		return thesis_id;
	}







	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}

}
