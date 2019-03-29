package com.BTP.actions.supervisor;

import com.opensymphony.xwork2.ActionSupport;

public class DisplayArchivesDetailsAction extends ActionSupport{

	private Object[] archivethesis;



	public String execute()
	{

		//System.out.println(thesis.length);


		return SUCCESS;
	}



	public Object[] getArchivethesis() {
		return archivethesis;
	}



	public void setArchivethesis(Object[] archivethesis) {
		this.archivethesis = archivethesis;
	}

}
