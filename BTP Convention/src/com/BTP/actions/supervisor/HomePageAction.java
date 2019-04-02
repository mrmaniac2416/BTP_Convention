package com.BTP.actions.supervisor;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.BTP.services.LoginService;

public class HomePageAction extends ActionSupport {
      private LoginService loginService=new LoginService();
      private List<Object[]> supervisorProfile;
      Map<String, Object> session = ActionContext.getContext().getSession();
      
      
	 
	  public String execute()
	  {
		  String userId=(String)session.get("userId");
		  this.supervisorProfile=this.loginService.genrateSupervisorProfile(userId);
		  return SUCCESS;
	  }
	public List<Object[]> getSupervisorProfile() {
		return supervisorProfile;
	}
	public void setSupervisorProfile(List<Object[]> supervisorProfile) {
		this.supervisorProfile = supervisorProfile;
	}
}
