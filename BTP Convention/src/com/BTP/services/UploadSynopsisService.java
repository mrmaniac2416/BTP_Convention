package com.BTP.services;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.BTP.JPA.student;

public class UploadSynopsisService {
	
	
	public void upload(byte[] array,String username)
	{
		
		Date date=new Date();
        
        Configuration con = new Configuration().configure().addAnnotatedClass(student.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session sessionQuery = sf.openSession();
       
        Transaction tx = sessionQuery.beginTransaction();
        
        Query q = sessionQuery.createQuery("update student set synopsis=:array ,synopsis_date=:date where student_id=" + "'" + username + "'");
        q.setParameter("array", array);
        q.setParameter("date", date);
        
        System.out.println("upload mein gaya");
        
        q.executeUpdate();
        
        tx.commit();
        sessionQuery.close();
        sf.close();
		
	}

}
