package com.BTP.actions.supervisor;



import com.opensymphony.xwork2.ActionSupport;

public class DisplayThesisDetailsAction extends ActionSupport{
	
	private Object[] thesis;


	
	
	public Object[] getThesis() {
		return thesis;
	}



	public void setThesis(Object[] thesis) {
		this.thesis = thesis;
	}



	public String execute()
	{
		
	System.out.println(thesis.length);
  
	 
		return SUCCESS;
	}
	
	

}
