package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class UpdateApp3 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Student student=null;
		Integer id = 6;
		try {
			session = HibernateUtil.getSession();
			student = session.get(Student.class, id);
			System.out.println(student);
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				if (student != null) {

					student.setSaddress("Dhalbhum");
					student.setSname("uday solanki");
					flag = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("✅ Record Updated successfully!");
				System.out.println(student);
			} else {
				transaction.rollback();
				System.out.println("❌ Record Updation Failed");
			}
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
