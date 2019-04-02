package com.BTP.actions.dean;

import com.opensymphony.xwork2.ActionSupport;

public class HomePageAction extends ActionSupport{
   
	
	public String execute()
	{
		System.out.println("in dean action");
		return SUCCESS;
	}
}
