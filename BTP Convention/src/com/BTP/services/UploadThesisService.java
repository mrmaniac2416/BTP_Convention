package com.BTP.services;

import com.BTP.JPA.student;
import com.BTP.JPA.thesis;
import com.BTP.JPA.users;

import java.util.*;

import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class UploadThesisService {
	
	public void upload(byte[] data,String user_id,String thesis_name)
	{
		
		thesis th = new thesis();
//		th.setThesis_id(1);
		th.setThesis_data(data);
		th.setThesis_name(thesis_name);
		th.setStatus("submitted");
		th.setSubmitted_date(new Date());
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(thesis.class).addAnnotatedClass(student.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
       
        Transaction tx = session.beginTransaction();
        
        session.save(th);
        
        
        System.out.println(user_id);
        
        Query q = session.createQuery("update student set thesis_id=" + th.getThesis_id() + " where student_id=" + "'" + user_id + "'");
        q.executeUpdate();
        tx.commit();
        
        session.close();
        sf.close();
	}

}
