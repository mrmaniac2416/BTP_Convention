package com.BTP.actions.dean;


import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import com.BTP.services.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomePageAction extends ActionSupport{
	
	private LoginService loginService=new LoginService();
    private List<Object[]> deanProfile;
    
    @Action("home-page")
    public String execute()
    {
		  this.deanProfile=this.loginService.genrateDeanProfile();
		  return SUCCESS;
    }
	
	
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}



	public List<Object[]> getDeanProfile() {
		return deanProfile;
	}



	public void setDeanProfile(List<Object[]> deanProfile) {
		this.deanProfile = deanProfile;
	}
	

}
