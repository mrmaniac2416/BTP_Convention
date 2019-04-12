package com.BTP.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.BTP.JPA.*;

public class DeanService {

	public Object[] ThesisDetails(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select t.thesis_name,u.user_name,nm.user_name from student s inner join users u on u.user_id=s.student_id inner join users nm on nm.user_id=s.supervisor_id inner join thesis t on t.thesis_id=s.thesis_id where t.thesis_id=:thesis_id");
		q.setParameter("thesis_id", thesis_id);
		Object[] thesisDetails = (Object[]) q.uniqueResult();
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


	public String acceptInvitation(String token)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(thesisreviewer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session sessionQuery = sf.openSession();

		Transaction tx = sessionQuery.beginTransaction();
		String preStatus="selected";
		String status="revieweraccepted";
		Query q = sessionQuery.createQuery("update thesisreviewer set status=:status where token=:token and status=:preStatus");
		q.setParameter("token", token);
		q.setParameter("status", status);
		q.setParameter("preStatus", preStatus);
		int num = q.executeUpdate();

		tx.commit();
		sessionQuery.close();
		sf.close();
		if(num==1)
			return "success";
		else
			return "error";
	}

	public void acceptReviewer(int thesisId,String email)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(thesisreviewer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session sessionQuery = sf.openSession();

		Transaction tx = sessionQuery.beginTransaction();
		String status="deanaccepted";
		Date date=new Date();
		Query q = sessionQuery.createQuery("update thesisreviewer set status=:status, accepteddate=:date where thesisreviewerId.thesisId=:thesisId and thesisreviewerId.reviewerId=:email");
		q.setParameter("thesisId", thesisId);
		q.setParameter("email", email);
		q.setParameter("status", status);
		q.setParameter("date", date);
		q.executeUpdate();

		tx.commit();
		sessionQuery.close();
		sf.close();
	}
	
	public List<Object[]> fetchAcceptedIndianReviewers(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(reviewerPK.class).addAnnotatedClass(thesisreviewerPK.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		String type="indian";
		String status="deanaccepted";
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select r.name,r.contact,r.reviewerId.email,tr.accepteddate from reviewer r inner join thesisreviewer tr on r.reviewerId.email=tr.thesisreviewerId.reviewerId and r.reviewerId.supervisor_id=tr.supervisorId where tr.thesisreviewerId.thesisId=:thesis_id and r.reviewerType=:type and tr.status=:status");
		q.setParameter("thesis_id", thesis_id);
		q.setParameter("type", type);
		q.setParameter("status", status);
		List<Object[]> indianReviewers = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return indianReviewers;
	}


	public List<Object[]> fetchAcceptedAbroadReviewers(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(reviewerPK.class).addAnnotatedClass(thesisreviewerPK.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		String type="abroad";
		String status="deanaccepted";
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select r.name,r.contact,r.reviewerId.email,tr.accepteddate from reviewer r inner join thesisreviewer tr on r.reviewerId.email=tr.thesisreviewerId.reviewerId and r.reviewerId.supervisor_id=tr.supervisorId where tr.thesisreviewerId.thesisId=:thesis_id and r.reviewerType=:type and tr.status=:status");
		q.setParameter("thesis_id", thesis_id);
		q.setParameter("type", type);
		q.setParameter("status", status);
		List<Object[]> abroadReviewers = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return abroadReviewers;
	}
	

	public List<Object[]> fetchReviewingIndianReviewers(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(reviewerPK.class).addAnnotatedClass(thesisreviewerPK.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		String type="indian";
		String status="addedToDashboard";
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select r.name,r.contact,r.reviewerId.email,tr.accepteddate from reviewer r inner join thesisreviewer tr on r.reviewerId.email=tr.thesisreviewerId.reviewerId and r.reviewerId.supervisor_id=tr.supervisorId where tr.thesisreviewerId.thesisId=:thesis_id and r.reviewerType=:type and tr.status=:status");
		q.setParameter("thesis_id", thesis_id);
		q.setParameter("type", type);
		q.setParameter("status", status);
		List<Object[]> indianReviewers = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return indianReviewers;
	}


	public List<Object[]> fetchReviewingAbroadReviewers(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(reviewerPK.class).addAnnotatedClass(thesisreviewerPK.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		String type="abroad";
		String status="addedToDashboard";
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select r.name,r.contact,r.reviewerId.email,tr.accepteddate from reviewer r inner join thesisreviewer tr on r.reviewerId.email=tr.thesisreviewerId.reviewerId and r.reviewerId.supervisor_id=tr.supervisorId where tr.thesisreviewerId.thesisId=:thesis_id and r.reviewerType=:type and tr.status=:status");
		q.setParameter("thesis_id", thesis_id);
		q.setParameter("type", type);
		q.setParameter("status", status);
		List<Object[]> abroadReviewers = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return abroadReviewers;
	}
	
	public List<Object[]> fetchReviewedIndianReviewers(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(reviewerPK.class).addAnnotatedClass(thesisreviewerPK.class).addAnnotatedClass(review.class).addAnnotatedClass(reviewPK.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		String type="indian";
		String status="reviewSent";
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select r.name,r.contact,r.reviewerId.email,rev.submissiondate from reviewer r "
				+ "inner join thesisreviewer tr on r.reviewerId.email=tr.thesisreviewerId.reviewerId and r.reviewerId.supervisor_id=tr.supervisorId "
				+ "inner join review rev on tr.thesisreviewerId.reviewerId=rev.reviewId.email_id and tr.thesisreviewerId.thesisId=rev.reviewId.thesis_id "
				+ "where tr.thesisreviewerId.thesisId=:thesis_id and r.reviewerType=:type and tr.status=:status");
		q.setParameter("thesis_id", thesis_id);
		q.setParameter("type", type);
		q.setParameter("status", status);
		List<Object[]> indianReviewers = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return indianReviewers;
		
	}
	
	
	
	public List<Object[]> fetchReviewedAbroadReviewers(int thesis_id)
	{

		Configuration con = new Configuration().configure().addAnnotatedClass(reviewer.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(reviewerPK.class).addAnnotatedClass(thesisreviewerPK.class).addAnnotatedClass(review.class).addAnnotatedClass(reviewPK.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		String type="abroad";
		String status="reviewSent";
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select r.name,r.contact,r.reviewerId.email,rev.submissiondate from reviewer r "
				+ "inner join thesisreviewer tr on r.reviewerId.email=tr.thesisreviewerId.reviewerId and r.reviewerId.supervisor_id=tr.supervisorId "
				+ "inner join review rev on tr.thesisreviewerId.reviewerId=rev.reviewId.email_id and tr.thesisreviewerId.thesisId=rev.reviewId.thesis_id "
				+ "where tr.thesisreviewerId.thesisId=:thesis_id and r.reviewerType=:type and tr.status=:status");
		q.setParameter("thesis_id", thesis_id);
		q.setParameter("type", type);
		q.setParameter("status", status);
		List<Object[]> indianReviewers = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return indianReviewers;
		
	}

	public List<Object[]> ArchiveThesis()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		String status[] = {"reviewersSelected","reviewing","reviewed"};
		List<String> list = Arrays.asList(status);
		Query q = session.createQuery("select t.thesis_id,t.thesis_name,u.user_name,nm.user_name,t.submitted_date,t.status from student s inner join users u on u.user_id=s.student_id inner join users nm on nm.user_id=s.supervisor_id inner join thesis t on t.thesis_id=s.thesis_id where t.status IN :list");
		q.setParameterList("list", list);
		List<Object[]> deanProfile = (List<Object[]>) q.list();
		
		
		tx.commit();
		session.close();
		sf.close();
		return deanProfile;
	}
	
	public void sendToSupervisor(int thesisId, String reviewerId)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(thesisreviewer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		String status="sentToSupervisor";
		Query q = session.createQuery("update thesisreviewer set status=:status where thesisreviewerId.reviewerId=:reviewerId and thesisreviewerId.thesisId=:thesisId");
		q.setParameter("status", status);
		q.setParameter("thesisId", thesisId);
		q.setParameter("reviewerId", reviewerId);
		
		q.executeUpdate();
		
		tx.commit();
		session.close();
		sf.close();
	}
}
