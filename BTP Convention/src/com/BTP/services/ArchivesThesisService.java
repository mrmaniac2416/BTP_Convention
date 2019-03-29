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

public class ArchivesThesisService {
	
	public List<Object[]> archivesThesisDashboard(String userId)
	{
		
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select t.thesis_id,t.thesis_name,u.user_name,t.submitted_date,t.status,u.user_id,s.research_area,s.synopsis_date from student s inner join users u on u.user_id=s.student_id inner join thesis t on t.thesis_id=s.thesis_id where s.supervisor_id=:userId and t.submitted_date >  (CURRENT_DATE-365) order by t.submitted_date desc");
		q.setParameter("userId", userId);
		List<Object[]> archivesThesis = (List<Object[]>) q.list();
		tx.commit();
		session.close();
		sf.close();
		return archivesThesis;
	}

}
