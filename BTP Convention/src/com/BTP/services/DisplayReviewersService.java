package com.BTP.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.BTP.JPA.reviewer;
import com.BTP.JPA.reviewerPK;
import com.BTP.JPA.student;
import com.BTP.JPA.thesis;
import com.BTP.JPA.users;

public class DisplayReviewersService {
	
	
	public List<reviewer> fetchReviewers(String userId)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(reviewer.class);
		cr.add(Restrictions.eq("reviewerId.supervisor_id",userId));
		
		List<reviewer> reviewers=cr.list();
		
		session.close();
		sf.close();
		
		
		return reviewers;
	}
	
	public reviewer fetchReviewer(String reviewer_supervisor_id,String reviewer_email_id)
	{
		reviewerPK reviewerId=new reviewerPK();
		reviewerId.setEmail_id(reviewer_email_id);
		reviewerId.setSupervisor_id(reviewer_supervisor_id);
		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(reviewer.class);
		cr.add(Restrictions.eq("reviewerId",reviewerId));
		
		return (reviewer) cr.uniqueResult();
		
	}

}
