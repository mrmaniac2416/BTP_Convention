package com.BTP.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import com.BTP.JPA.student;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success",type="stream",params= {"contentType","application/pdf","inputName","inputStream","contentDisposition"
		,"filename=fileName","bufferSize","1024"})
public class DownloadSynopsisAction extends ActionSupport{
	
	private String student_id;
	private InputStream inputStream;
	private String fileName;
	
	
	public String execute() throws IOException
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(student.class);
		SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        response.setContentType("application/pdf");
        Query q=session.createQuery("select synopsis from student where student_id=:student_id");
        q.setParameter("student_id", student_id);
        
        byte [] data=(byte[])q.uniqueResult();
        
        response.setContentLength(data.length);
        
        setFileName(this.getStudent_id() + "_synopsis");
        setInputStream(new ByteArrayInputStream (data));
        
        
        
        
        tx.commit();
        session.close();
        sf.close();
        
        
        return SUCCESS;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
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

}
