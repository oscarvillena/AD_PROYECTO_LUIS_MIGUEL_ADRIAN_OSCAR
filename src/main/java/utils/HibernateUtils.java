package utils;

import org.hibernate.cfg.Configuration;

import org.hibernate.SessionFactory;

public class HibernateUtils {

	static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
