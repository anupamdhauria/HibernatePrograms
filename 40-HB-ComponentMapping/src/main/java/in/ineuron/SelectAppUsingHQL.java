package in.ineuron;

import in.ineuron.util.HibernateUtil;

import in.ineuron.model.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


public class SelectAppUsingHQL {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			Query<Student> query = session.createQuery("from in.ineuron.model.Student where address.cityName=:city");
			query.setParameter("city", "Bengaluru");

			List<Student> student = query.list();
			student.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
