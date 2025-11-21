package in.ineuron;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


public class SelectApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			Query<Employee> query = session.createQuery("FROM in.ineuron.model.Employee");
			List<Employee> resultList = query.getResultList();
			resultList.forEach(System.out::println);
			
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
