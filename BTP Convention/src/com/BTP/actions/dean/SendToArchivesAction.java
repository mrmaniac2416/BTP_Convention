package com.BTP.actions.dean;

import org.apache.struts2.convention.annotation.Result;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionSupport;


@Result(name="success",location="home-page",type="redirectAction")
public class SendToArchivesAction extends ActionSupport{

	
	private int thesisId;
	
	private DeanService deanService=new DeanService();
	
	
	public String execute()
	{
		this.deanService.sendToArchives(thesisId);
		return SUCCESS;
	}

	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}
	
	
}
