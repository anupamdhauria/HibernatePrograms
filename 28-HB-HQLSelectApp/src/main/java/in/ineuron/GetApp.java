package in.ineuron;


import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class GetApp {

	public static void main(String[] args) {

		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			@SuppressWarnings({ "deprecation", "unchecked" })
			Query<Student> query = session.createQuery("From in.ineuron.model.Student");
			if (query != null) {
				List<Student> list = query.list();
				list.forEach(System.out::println);
			} else
				System.out.println("Record not found");

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
