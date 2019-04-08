package com.BTP.actions;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import com.BTP.JPA.thesis;


@Result(name="success",type="stream",params= {"contentType","application/pdf","inputName","inputStream","contentDisposition"
		,"filename=${fileName}","bufferSize","1024"})
public class DownloadThesisAction extends ActionSupport{

	private int thesis_id;
	private InputStream inputStream;
	private String fileName;

	public int getThesis_id() {
		return thesis_id;
	}

	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}


	public String execute() throws IOException
	{
		HttpServletResponse response = ServletActionContext.getResponse();

		Configuration con = new Configuration().configure().addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		
        

		Query q=session.createQuery("select thesis_data from thesis where thesis_id=" + thesis_id);

		byte [] data=(byte[])q.uniqueResult();


		q=session.createQuery("select thesis_name from thesis where thesis_id=" + thesis_id);
		response.setContentLength(data.length);
		setFileName((String)q.uniqueResult());

		setInputStream(new ByteArrayInputStream (data));
		
		tx.commit();
		
		session.close();
		sf.close();
		
		return SUCCESS;
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
