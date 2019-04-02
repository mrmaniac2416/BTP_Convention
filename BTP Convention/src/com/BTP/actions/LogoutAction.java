package com.BTP.actions;

import java.util.Map;

import javax.servlet.ServletConfig;

import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class LogoutAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String execute()
	{
		session.clear();
		return SUCCESS;
	}

}
