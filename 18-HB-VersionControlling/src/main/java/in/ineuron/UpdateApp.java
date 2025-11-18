package in.ineuron;

import in.ineuron.model.MobileNumberInfo;
import in.ineuron.util.HibernateUtil;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateApp implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id = 1;
		MobileNumberInfo numberInfo = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			System.out.println(session);

			numberInfo = session.get(MobileNumberInfo.class, id);

			if (session != null) {
				transaction = session.beginTransaction();
			}
			Integer countCallerTimeLimit=numberInfo.getVersionCount();
			if(countCallerTimeLimit<1) {
				if (transaction != null) {
					System.out.println("before transaction::" + numberInfo);
					numberInfo.setCallerTune("Sachin India........");
					session.update(numberInfo);
					flag = true;
				}
			}else {
				System.out.println("Count limit already reached");
				flag=false;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("✅ Record Updated successfully!");
				System.out.println("After transaction::" + numberInfo);
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
