package com.BTP.actions.dean;

import com.opensymphony.xwork2.ActionSupport;

public class SendInvitationModalAction extends ActionSupport{
	
	private String email;
	
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
	

}
