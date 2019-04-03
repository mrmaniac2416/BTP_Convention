package com.BTP.actions.dean;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionSupport;

public class AcceptInvitationAction extends ActionSupport{
	private String token;
	DeanService deanService = new DeanService();
	
	public String execute()
	{
		System.out.println("Hello");
		deanService.acceptInvitation(token);
		return SUCCESS;
	}
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
