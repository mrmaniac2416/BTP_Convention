package com.BTP.actions.dean;

import com.opensymphony.xwork2.ActionSupport;

public class SendInvitationModalAction extends ActionSupport{
	
	private String email;
	private int thesis_id;
	
	public String execute()
	{
		System.out.println(email);
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getThesis_id() {
		return thesis_id;
	}

	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}
	

}
