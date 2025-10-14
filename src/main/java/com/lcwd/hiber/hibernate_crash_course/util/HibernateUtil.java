package com.lcwd.hiber.hibernate_crash_course.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lcwd.hiber.hibernate_crash_course.entities.Certificate;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static { //initialization block
		
		try {
			
			if(sessionFactory == null) {
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Certificate.class).buildSessionFactory();
			}
			
		} catch(Exception e) {
			throw new RuntimeException("Error in Creating Session Factory " + e.getMessage());
		}
		
	}
	
	 //method to get session factory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
