package com.BTP.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import java.util.*;

import com.BTP.JPA.reviewer;
import com.BTP.JPA.student;
import com.BTP.JPA.tempstudent;
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
		
		Query q = session.createQuery("select t.thesis_id,t.thesis_name,u.user_name,t.submitted_date,t.status,u.user_id from student s inner join users u on u.user_id=s.student_id inner join thesis t on t.thesis_id=s.thesis_id where s.supervisor_id=:userId and t.status!=:status");
		q.setParameter("userId", userId);
		q.setParameter("status", "defended");
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
	
	public String checkResetToken(String token,String email)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Criteria cr = session.createCriteria(users.class);
		
		cr.add(Restrictions.eq("user_id",email));
		cr.add(Restrictions.eq("token",token));
		
		users result=(users)cr.uniqueResult();
		
		tx.commit();
		session.close();
		sf.close();
		
		return result!=null ? "success" : "error";
		
		
	}
	
	public String checkSignupToken(String token,String email)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(tempstudent.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Criteria cr = session.createCriteria(tempstudent.class);
		
		cr.add(Restrictions.eq("email",email));
		cr.add(Restrictions.eq("token",token));
		
		tempstudent result=(tempstudent)cr.uniqueResult();
		
		tx.commit();
		session.close();
		sf.close();
		
		return result!=null ? "success" : "error";
		
		
	}
	
	public void createStudentAccount(String email)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(tempstudent.class).addAnnotatedClass(users.class).addAnnotatedClass(student.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Criteria cr = session.createCriteria(tempstudent.class);
		
		cr.add(Restrictions.eq("email",email));
		
		tempstudent result=(tempstudent)cr.uniqueResult();
		
		
		
		users user=new users();
		
		user.setUser_id(result.getEmail());
		user.setPasswd(result.getPassword());
		user.setUser_name(result.getName());
		user.setUser_type("student");
		
		student student=new student();
		
		student.setResearch_area(result.getResearch_area());
		student.setStudent_id(result.getEmail());
		student.setSupervisor_id(result.getSupervisor_id());
		student.setThesis_id(null);
		
		session.save(user);
		session.save(student);
		session.delete(result);
		
		tx.commit();
		session.close();
		sf.close();
		
		
		
	}
	
	
	
	public List<users> getSupervisors()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Criteria cr = session.createCriteria(users.class);
		
		cr.add(Restrictions.eq("user_type","supervisor"));
//		ProjectionList projList = Projections.projectionList();
//		projList.add(Projections.property("user_name"));
//		cr.setProjection(projList);
		
		List<users> results=(List<users>)cr.list();
		
		tx.commit();
		session.close();
		sf.close();
		
		return results;
	}
	
	
	
	
	
	public String updatePassword(String password,String email,String token)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(users.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(users.class);
		cr.add(Restrictions.eq("user_id",email));
		cr.add(Restrictions.eq("token",token));
		users user=(users)cr.uniqueResult();
		if(user==null)
			return "error";
//		users user=session.get(users.class, email);
		user.setPasswd(password);
		user.setToken(null);
		session.update(user);
		
		tx.commit();
		session.close();
		sf.close();
		return "success";
	}


}
