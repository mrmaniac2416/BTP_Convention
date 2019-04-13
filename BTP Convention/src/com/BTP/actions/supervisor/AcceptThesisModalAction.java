package com.BTP.actions.supervisor;

import com.opensymphony.xwork2.ActionSupport;

public class AcceptThesisModalAction extends ActionSupport{
	
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
