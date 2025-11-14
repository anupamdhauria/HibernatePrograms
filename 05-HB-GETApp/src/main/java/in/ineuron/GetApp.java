package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class GetApp {

	public static void main(String[] args) {

		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Integer id = 4;
		try {
			session = HibernateUtil.getSession();
			Student student = session.get(Student.class, id);
			if (student != null)
				System.out.println(student);
			else
				System.out.println("Record not found for the given id :: " + id);

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
