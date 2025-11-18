package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Product;

public class OracleHibernateUtil {

	private static SessionFactory sessionFactory=null;
	private static Session session=null;
	
	private OracleHibernateUtil() {
		
	}
	static {	
		
		if(sessionFactory==null) 
			sessionFactory=new Configuration().configure("oracle-hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		System.out.println(sessionFactory);
	}
	
	
	public static Session getSession() {
		if(session==null)
			session=sessionFactory.openSession();
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
