package com.BTP.actions.dean;

import com.opensymphony.xwork2.ActionSupport;

public class GenerateUserModalAction extends ActionSupport{
	
	private String email;
	
	
	public String execute()
	{
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
