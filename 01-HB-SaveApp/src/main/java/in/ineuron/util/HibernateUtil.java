package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory=null;
	private static Session session=null;
	
	static {
		try {
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
		session=getSessionfactory().openSession();
		return session;
	}
	
	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}
}
