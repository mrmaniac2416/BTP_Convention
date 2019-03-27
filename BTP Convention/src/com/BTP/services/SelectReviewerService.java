package com.BTP.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.BTP.JPA.student;
import com.BTP.JPA.thesis;
import com.BTP.JPA.users;

public class SelectReviewerService {
	
	
	public List<Object[]> selectReviewerDashboard(String userId)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		String accepted="accepted";
		Query q = session.createQuery("select t.thesis_id,t.thesis_name,u.user_name,t.submitted_date from student s inner join users u on u.user_id=s.student_id inner join thesis t on t.thesis_id=s.thesis_id where t.status=:accepted and s.supervisor_id=:userId order by t.submitted_date desc");
		q.setParameter("userId", userId);
		q.setParameter("accepted", accepted);
		List<Object[]> acceptedThesis = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return acceptedThesis;
	}
	
	public void submitReviewers(int thesis_id,String []reviewersEmail)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
	    Query q = session.createQuery("update thesis set indian_reviewer_email_id=:reviewersEmail where thesis_id=:thesis_id");
        q.setParameter("reviewersEmail", reviewersEmail);
        q.setParameter("thesis_id", thesis_id);
        
        System.out.println("upload mein gaya");
        
        q.executeUpdate();
        
        tx.commit();
        session.close();
        sf.close();
				
		
		
	}

}
