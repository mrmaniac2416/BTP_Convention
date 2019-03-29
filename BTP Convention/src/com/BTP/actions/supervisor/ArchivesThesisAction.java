package com.BTP.actions.supervisor;

import java.util.List;
import java.util.Map;

import com.BTP.services.ArchivesThesisService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArchivesThesisAction extends ActionSupport{
	Map<String, Object> session = ActionContext.getContext().getSession();
	private List<Object[]> archivesThesis;
	private int thesisId;
	ArchivesThesisService archives = new ArchivesThesisService();
	public String execute()
	{
		String userId=(String)session.get("userId");
		setArchivesThesis(archives.archivesThesisDashboard(userId));
		return SUCCESS ;
		
		
	}
	public List<Object[]> getArchivesThesis() {
		return archivesThesis;
	}
	public void setArchivesThesis(List<Object[]> archivesThesis) {
		this.archivesThesis = archivesThesis;
	}
	public int getThesisId() {
		return thesisId;
	}
	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}
	

}
