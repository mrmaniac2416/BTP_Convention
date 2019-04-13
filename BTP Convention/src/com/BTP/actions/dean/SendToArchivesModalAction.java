package com.BTP.actions.dean;

import com.opensymphony.xwork2.ActionSupport;

public class SendToArchivesModalAction extends ActionSupport{

	private int thesisId;
	
	
	public String execute()
	{
		return SUCCESS;
	}

	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}
	
	
	
}
