package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class DeleteApp1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Integer id = 8;
		try {
			session = HibernateUtil.getSession();
			System.out.println(session);
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Student student = new Student();
				student.setSid(id);
				session.delete(student);
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("✅ Record Deleted successfully!");
			} else {
				transaction.rollback();
				System.out.println("❌ Record Deletion Failed");
			}
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
