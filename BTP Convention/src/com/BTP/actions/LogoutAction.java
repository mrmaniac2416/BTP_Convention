package com.BTP.actions;

import javax.servlet.ServletConfig;

import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


@Result(name="success", type="redirect",location="login-page")
public class LogoutAction extends ActionSupport{
	
	public String execute()
	{
		
		return SUCCESS;
	}

}
