package com.BTP.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.BTP.JPA.*;

public class DeanService {

	public List<Object[]> ThesisDetails(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select t.thesis_name,u.user_name,nm.user_name from student s inner join users u on u.user_id=s.student_id inner join users nm on nm.user_id=s.supervisor_id inner join thesis t on t.thesis_id=s.thesis_id where t.thesis_id=:thesis_id");
		q.setParameter("thesis_id", thesis_id);
		List<Object[]> thesisDetails = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return thesisDetails;
	}

	public List<Object[]> fetchIndianReviewers(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(reviewerPK.class).addAnnotatedClass(thesisreviewerPK.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		String type="indian";
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select r.name,r.affiliation,r.designation,r.contact,r.reviewerId.email,tr.sentdate,tr.status from reviewer r inner join thesisreviewer tr on r.reviewerId.email=tr.thesisreviewerId.reviewerId and r.reviewerId.supervisor_id=tr.supervisorId where tr.thesisreviewerId.thesisId=:thesis_id and r.reviewerType=:type");
		q.setParameter("thesis_id", thesis_id);
		q.setParameter("type", type);
		List<Object[]> indianReviewers = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return indianReviewers;
	}


	public List<Object[]> fetchAbroadReviewers(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(reviewerPK.class).addAnnotatedClass(thesisreviewerPK.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		String type="abroad";
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select r.name,r.affiliation,r.designation,r.contact,r.reviewerId.email,tr.sentdate,tr.status from reviewer r inner join thesisreviewer tr on r.reviewerId.email=tr.thesisreviewerId.reviewerId and r.reviewerId.supervisor_id=tr.supervisorId where tr.thesisreviewerId.thesisId=:thesis_id and r.reviewerType=:type");
		q.setParameter("thesis_id", thesis_id);
		q.setParameter("type", type);
		List<Object[]> abroadReviewers = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return abroadReviewers;
	}


	public void acceptInvitation(String token)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(thesisreviewer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session sessionQuery = sf.openSession();

		Transaction tx = sessionQuery.beginTransaction();
		String status="revieweraccepted";
		Query q = sessionQuery.createQuery("update thesisreviewer set status=:status where token=:token");
		q.setParameter("token", token);
		q.setParameter("status", status);

		q.executeUpdate();

		tx.commit();
		sessionQuery.close();
		sf.close();
	}

	public void acceptReviewer(int thesisId,String email)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(thesisreviewer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session sessionQuery = sf.openSession();

		Transaction tx = sessionQuery.beginTransaction();
		String status="deanaccepted";
		Query q = sessionQuery.createQuery("update thesisreviewer set status=:status where thesisreviewerId.thesisId=:thesisId and thesisreviewerId.reviewerId=:email");
		q.setParameter("thesisId", thesisId);
		q.setParameter("email", email);
		q.setParameter("status", status);

		q.executeUpdate();

		tx.commit();
		sessionQuery.close();
		sf.close();
	}

}
