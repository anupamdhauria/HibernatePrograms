package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class LoadAndMergeApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		Student std1=null;
		Student std2=null;
		Student std3=null;
		try {

			session = HibernateUtil.getSession();
			 std1 = session.get(Student.class, 5);
			 System.out.println("After loading the data into L1-cache :: "+std1);

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				std2 = new Student();

				std2.setSid(5);
				std2.setSname("Suresh");
				std2.setSaddress("CSK");
				std2.setMarks(90.3);
				System.out.println(std2);
				std3=session.merge(std2);
				System.out.println("After merging in L1Cache :: "+std3);
				System.out.println(std1.hashCode() + ":: " + std2.hashCode() + ":: " + std3.hashCode());
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("✅ Record Updated or Insterted successfully!");
			} else {
				transaction.rollback();
				System.out.println("❌ Record  Updation or Insertion Failed");
			}
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
