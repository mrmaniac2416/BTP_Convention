package com.BTP.actions.student;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.BTP.services.LoginService;


public class HomePageAction extends ActionSupport{
	private LoginService loginService=new LoginService();
    private List<Object> studentProfile;
    Map<String, Object> session = ActionContext.getContext().getSession();
    
    
	 
	  public String execute()
	  {
		  String userId=(String)session.get("userId");
		  this.setStudentProfile(this.loginService.generateStudentProfile(userId));
		  System.out.println("in student action");
		  return SUCCESS;
	  }



	public List<Object> getStudentProfile() {
		return studentProfile;
	}



	public void setStudentProfile(List<Object> studentProfile) {
		this.studentProfile = studentProfile;
	}

}
