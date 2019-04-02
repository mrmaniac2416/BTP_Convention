package com.BTP.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.*;

import com.BTP.JPA.student;
import com.BTP.JPA.users;
import com.BTP.JPA.thesis;



public class LoginService {



	public Object[] authenticate(String userId,String password)
	{
		try{

			if(userId==null || password==null || userId.trim().equals("") || password.trim().equals(""))
				return null;

			Configuration con = new Configuration().configure().addAnnotatedClass(users.class);
           
			SessionFactory sf = con.buildSessionFactory();

			Session session = sf.openSession();

			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("select user_id,user_name,passwd,user_type from users where user_id="+ "'" + userId + "'" + "and passwd=" + "'" + password + "'");
			//	 
			Object[] u = (Object[]) q.uniqueResult();

			//			System.out.println(u[0] + " : " + u[1] + " : " + u[2]);
			
			tx.commit();
			session.close();
			sf.close();
			
			return u;



		}

		catch(Exception es){
			es.printStackTrace();
		}
		return null;

	}

	public List<Object> generateStudentProfile(String userId)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("select u.user_id,u.user_name,s.research_area,s.synopsis,s.synopsis_date,s.thesis_id from users u,student s where u.user_id=s.student_id and s.student_id="+ "'" + userId + "'");
		Object[] u = (Object[]) q.uniqueResult();
		List<Object> list=new ArrayList<>(Arrays.asList(u));
		for(Object field:u)
			System.out.print(field + " : ");

		Query q1 = session.createQuery("select u.user_name from users u,student s where s.supervisor_id=u.user_id and s.student_id="+ "'" + userId + "'");
		Object sname = (Object) q1.uniqueResult();
		System.out.println(sname);

		list.add(sname);
		tx.commit();
		session.close();
		sf.close();
		return list;
	}


	public List<Object[]> genrateSupervisorProfile(String userId)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		Query q = session.createQuery("select t.thesis_id,t.thesis_name,u.user_name,t.submitted_date,t.status from student s inner join users u on u.user_id=s.student_id inner join thesis t on t.thesis_id=s.thesis_id where s.supervisor_id=:userId and t.submitted_date >  (CURRENT_DATE-365)");
		q.setParameter("userId", userId);
		List<Object[]> supervisorProfile = (List<Object[]>) q.list();
		
//		for(Object[] t: supervisorProfile)
//		{
//			System.out.println(t[0]+" : "+t[1]+ " : "+t[2]);
//		}

		
		tx.commit();
		session.close();
		sf.close();
		return supervisorProfile;
	}
	
	
	
	public List<Object[]> genrateDeanProfile()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class).addAnnotatedClass(student.class).addAnnotatedClass(thesis.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		String status="reviewersSelected";
		Query q = session.createQuery("select t.thesis_id,t.thesis_name,u.user_name,nm.user_name,t.submitted_date,t.status from student s inner join users u on u.user_id=s.student_id inner join users nm on nm.user_id=s.supervisor_id inner join thesis t on t.thesis_id=s.thesis_id where t.status=:status and t.submitted_date >  (CURRENT_DATE-365)");
		q.setParameter("status", status);
		List<Object[]> deanProfile = (List<Object[]>) q.list();
		
		
		tx.commit();
		session.close();
		sf.close();
		return deanProfile;
	}


}
