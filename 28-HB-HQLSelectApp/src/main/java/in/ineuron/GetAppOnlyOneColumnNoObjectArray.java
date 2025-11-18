package in.ineuron;


import in.ineuron.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class GetAppOnlyOneColumnNoObjectArray {

	public static void main(String[] args) {

		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			@SuppressWarnings({ "deprecation", "unchecked" })
			Query<Double> query = session.createQuery("SELECT marks From in.ineuron.model.Student WHERE sname IN (:stud1,:stud2)");
			query.setParameter("stud1", "anupam");
			query.setParameter("stud2", "kavita");
//				List<Double> list = query.list();
				List<Double> list = query.getResultList();//both are same but getResultSet has better performance
				System.out.println("========================================================");
				System.out.println("SMARKS");
				System.out.println("--------------------------------------------------------");
				list.forEach(System.out::println);
				System.out.println("========================================================");
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
