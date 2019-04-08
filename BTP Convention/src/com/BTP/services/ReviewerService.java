package com.BTP.services;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.BTP.JPA.review;
import com.BTP.JPA.reviewPK;
import com.BTP.JPA.reviewer;
import com.BTP.JPA.reviewerPK;
import com.BTP.JPA.student;
import com.BTP.JPA.thesis;
import com.BTP.JPA.thesisreviewer;
import com.BTP.JPA.users;

public class ReviewerService {
	
	
	
	public List<Object[]> generatePendingReviews(String reviewerId)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class).addAnnotatedClass(thesisreviewer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		String status="addedToDashboard";
		
		Query q = session.createQuery("select u.user_name,t.thesis_name,su.user_name,t.submitted_date,s.student_id,t.thesis_id from thesisreviewer tr "
				+ "inner join thesis t on tr.thesisreviewerId.thesisId=t.thesis_id "
				+ "inner join student s on s.thesis_id=t.thesis_id "
				+ "inner join users u on s.student_id=u.user_id "
				+ "inner join users su on s.supervisor_id=su.user_id "
				+ "where tr.status=:status and tr.thesisreviewerId.reviewerId=:reviewerId");
		q.setParameter("status", status);
		q.setParameter("reviewerId", reviewerId);
		
		List<Object[]> pendingReviews=(List<Object[]>)q.list();
		tx.commit();
		session.close();
		sf.close();
		
		return pendingReviews;
		
		
	}
	
	public void uploadReview(int thesisId,String reviewerId,byte[] reviewBytes)
	{
        Configuration con = new Configuration().configure().addAnnotatedClass(review.class).addAnnotatedClass(thesisreviewer.class);
        
        SessionFactory sf = con.buildSessionFactory();
        String status="reviewSent";
        Session session = sf.openSession();
        review review=new review();
        reviewPK reviewId=new reviewPK();
        
        reviewId.setEmail_id(reviewerId);
        reviewId.setThesis_id(thesisId);
        
        review.setReview(reviewBytes);
        review.setReviewId(reviewId);
        review.setSubmissiondate(new Date());
        
        Transaction tx = session.beginTransaction();
        session.save(review);
        Query q=session.createQuery("update thesisreviewer set status=:status where thesisreviewerId.thesisId=:thesisId and thesisreviewerId.reviewerId=:reviewerId");
        q.setParameter("status", status);
        q.setParameter("thesisId", thesisId);
        q.setParameter("reviewerId", reviewerId);
        q.executeUpdate();
        tx.commit();
		session.close();
		sf.close();
		      
        
	}
	
	
	public List<Object[]> generateSentReviews(String reviewerId)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class).addAnnotatedClass(thesisreviewer.class).addAnnotatedClass(review.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		String status="reviewSent";
		
		Query q = session.createQuery("select u.user_name,t.thesis_name,su.user_name,t.submitted_date,r.submissiondate,s.student_id,t.thesis_id from thesisreviewer tr "
				+ "inner join thesis t on tr.thesisreviewerId.thesisId=t.thesis_id "
				+ "inner join student s on s.thesis_id=t.thesis_id "
				+ "inner join users u on s.student_id=u.user_id "
				+ "inner join users su on s.supervisor_id=su.user_id "
				+ "inner join review r on t.thesis_id=r.reviewId.thesis_id "
				+ "where tr.status=:status and tr.thesisreviewerId.reviewerId=:reviewerId and r.reviewId.email_id=:reviewerId");
		q.setParameter("status", status);
		q.setParameter("reviewerId", reviewerId);
		
		List<Object[]> sentReviews=(List<Object[]>)q.list();
		tx.commit();
		session.close();
		sf.close();
		
		return sentReviews;
		
		
	}

}
