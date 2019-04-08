package com.BTP.actions.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import com.BTP.services.LoginService;
import com.BTP.services.UploadSynopsisService;

@InterceptorRef(value="loginStack", params= {"fileUpload.maximumSize","10485760","fileUpload.allowedTypes","application/pdf"})
@Result(name= {"success","input"},location="home-page.jsp")
public class SubmitSynopsisAction extends ActionSupport {

	private File file;
	private String userId;
	private List<Object> studentProfile;
	LoginService loginService=new LoginService();
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
	public List<Object> getStudentProfile() {
		return studentProfile;
	}

	public void setStudentProfile(List<Object> studentProfile) {
		this.studentProfile = studentProfile;
	}
	
	
	public void validate()
	{
		if(file==null)
		{
			
			setStudentProfile(loginService.generateStudentProfile(userId));
			addFieldError("file","Add a file");
		}
	}
	
	public String execute() throws IOException
	{
		  byte[] bytesArray = new byte[(int) file.length()]; 

		  FileInputStream fis = new FileInputStream(file);
		  fis.read(bytesArray); //read file into bytes[]
		  System.out.println(bytesArray);
		  System.out.println(userId);
		  fis.close();
		  UploadSynopsisService ud=new UploadSynopsisService();
	      ud.upload(bytesArray, userId);
	      setStudentProfile(loginService.generateStudentProfile(userId));
	      return SUCCESS;
		  
		  
	}

	

	
	
}
