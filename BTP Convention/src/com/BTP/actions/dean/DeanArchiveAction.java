package com.BTP.actions.dean;

import java.util.List;

import com.BTP.services.DeanService;
import com.opensymphony.xwork2.ActionSupport;

public class DeanArchiveAction extends ActionSupport{
	
	private DeanService deanService=new DeanService();
    private List<Object[]> archiveThesis;

    
    public String execute()
    {
    	setArchiveThesis(deanService.archiveThesis());
    	return SUCCESS;
    }


	public List<Object[]> getArchiveThesis() {
		return archiveThesis;
	}


	public void setArchiveThesis(List<Object[]> archiveThesis) {
		this.archiveThesis = archiveThesis;
	}
    
    
}
