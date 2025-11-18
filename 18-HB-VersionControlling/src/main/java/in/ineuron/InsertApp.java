package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.MobileNumberInfo;
import in.ineuron.util.HibernateUtil;

import java.io.Serializable;

import org.hibernate.Session;

public class InsertApp implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Integer id = null;
		try {
			session = HibernateUtil.getSession();
			System.out.println(session);
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				MobileNumberInfo numberInfo = new MobileNumberInfo();
				numberInfo.setCname("Sachin");
				numberInfo.setMobileno(2234445567L);
				numberInfo.setCallerTune("Mi MI...");
				id = (Integer) session.save(numberInfo);
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("✅ Record inserted successfully!");
				System.out.println("Object saved with id:" + id);
			} else {
				transaction.rollback();
				System.out.println("❌ Record Insertion Failed");
			}
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
