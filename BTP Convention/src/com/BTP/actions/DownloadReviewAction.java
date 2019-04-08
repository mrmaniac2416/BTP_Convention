package com.BTP.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.BTP.JPA.review;
import com.BTP.JPA.student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="success",type="stream",params= {"contentType","application/pdf","inputName","inputStream","contentDisposition"
		,"filename=${fileName}","bufferSize","1024"})
public class DownloadReviewAction extends ActionSupport{
	
	private int thesis_id;
	private InputStream inputStream;
	private String fileName;
	private String thesis_title;
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	

	public String execute() throws IOException
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		String reviewerId=(String)session.get("userId");
		
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(review.class);
		
		SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        response.setContentType("application/pdf");
        Query q=session.createQuery("select review from review where reviewId.email_id=:reviewerId and reviewId.thesis_id=:thesis_id");
        q.setParameter("reviewerId", reviewerId);
        q.setParameter("thesis_id", thesis_id);
        
        byte [] data=(byte[])q.uniqueResult();
        
        response.setContentLength(data.length);
        
        setFileName(this.thesis_title + "_review");
        setInputStream(new ByteArrayInputStream (data));
        
        
        
        
        tx.commit();
        session.close();
        sf.close();
        
        
        return SUCCESS;
	}

	public int getThesis_id() {
		return thesis_id;
	}

	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getThesis_title() {
		return thesis_title;
	}

	public void setThesis_title(String thesis_title) {
		this.thesis_title = thesis_title;
	}
	
	

}
