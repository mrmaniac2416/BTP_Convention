package com.BTP.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.BTP.JPA.reviewer;
import com.BTP.JPA.student;
import com.BTP.JPA.thesis;
import com.BTP.JPA.thesisreviewer;
import com.BTP.JPA.users;

public class ArchivesThesisService {
	
	public List<Object[]> archivesThesisDashboard(String userId)
	{
		
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();
		String status="defended";

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select t.thesis_id,t.thesis_name,u.user_name,t.submitted_date,u.user_id,s.research_area,s.synopsis_date from student s inner join users u on u.user_id=s.student_id inner join thesis t on t.thesis_id=s.thesis_id where s.supervisor_id=:userId and t.status=:status");
		q.setParameter("userId", userId);
		q.setParameter("status", status);
		List<Object[]> archivesThesis = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return archivesThesis;
	}
	
	public List<Object[]> reviewedThesis(String userId)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		String status="reviewed";
		Query q = session.createQuery("select t.thesis_id,t.thesis_name,u.user_name,t.submitted_date,t.status from student s inner join users u on u.user_id=s.student_id inner join thesis t on t.thesis_id=s.thesis_id where s.supervisor_id=:userId and t.status=:status");
		q.setParameter("userId", userId);
		q.setParameter("status", status);
		List<Object[]> reviewedThesis = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return reviewedThesis;
	}
	public List<Object[]> thesisReviews(int thesisId)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(thesis.class).addAnnotatedClass(reviewer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		String status="sentToSupervisor";
		Query q = session.createQuery("select r.name,t.thesis_id,t.thesis_name,tr.thesisreviewerId.reviewerId from thesisreviewer tr inner join thesis t on tr.thesisreviewerId.thesisId=t.thesis_id inner join reviewer r on r.reviewerId.email=tr.thesisreviewerId.reviewerId"
				+ " where tr.thesisreviewerId.thesisId=:thesisId and tr.status=:status");
		q.setParameter("status", status);
		q.setParameter("thesisId", thesisId);
		List<Object[]> reviewedThesis = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return reviewedThesis;
	}

}
