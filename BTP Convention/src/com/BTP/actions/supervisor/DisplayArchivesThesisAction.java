package com.BTP.actions.supervisor;

import java.util.List;

import com.BTP.services.ArchivesThesisService;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayArchivesThesisAction extends ActionSupport{

	private Object[] archivethesis;
	ArchivesThesisService review = new ArchivesThesisService();
	private List<Object[]> reviewers;


	public String execute()
	{

		//System.out.println(thesis.length);

		setReviewers(review.thesisReviews(Integer.parseInt((String) archivethesis[0])));
		return SUCCESS;
	}



	public Object[] getArchivethesis() {
		return archivethesis;
	}



	public void setArchivethesis(Object[] archivethesis) {
		this.archivethesis = archivethesis;
	}



	public List<Object[]> getReviewers() {
		return reviewers;
	}



	public void setReviewers(List<Object[]> reviewers) {
		this.reviewers = reviewers;
	}

}
