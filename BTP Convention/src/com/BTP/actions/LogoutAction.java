package com.BTP.actions;

import java.util.Map;

import javax.servlet.ServletConfig;

import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Result(name="success", type="redirect",location="login-page")
public class LogoutAction extends ActionSupport{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String execute()
	{
		session.remove("usertype");
		session.clear();
		System.out.println("***************************");
		System.out.println("in logout");
		System.out.println("in logout usertype " + session.get("usertype"));
		System.out.println("****************************");
		
		return SUCCESS;
	}

}
