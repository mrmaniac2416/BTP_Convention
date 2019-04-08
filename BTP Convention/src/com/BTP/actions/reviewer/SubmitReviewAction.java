package com.BTP.actions.reviewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.BTP.services.ReviewerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;


@InterceptorRef(value="loginStack", params= {"fileUpload.maximumSize","10485760","fileUpload.allowedTypes","application/pdf"})
@Results({
@Result(name= "input",location="pending-review-details.jsp"),
@Result(name="success",location="pending-reviews",type="redirectAction")})
public class SubmitReviewAction extends ActionSupport{


	private int thesisId;
	private File file;
	private Object[] pendingReview;
	
	ReviewerService reviewerService=new ReviewerService();

	public File getFile() {
		return file;
	}
    
	
	@RequiredFieldValidator(message="Enter a file")
	public void setFile(File file) {
		this.file = file;
	}

	Map<String, Object> session = ActionContext.getContext().getSession();


	public String execute() throws IOException
	{
		String reviewerId=(String)session.get("userId");
	
		byte[] bytesArray = new byte[(int) file.length()]; 

		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); //read file into bytes[]
		System.out.println(bytesArray);
		fis.close();
		this.reviewerService.uploadReview(thesisId, reviewerId, bytesArray);
		return SUCCESS;
	}

	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}

	public Object[] getPendingReview() {
		return pendingReview;
	}

	public void setPendingReview(Object[] pendingReview) {
		this.pendingReview = pendingReview;
	}




}
