package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class DeleteApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			System.out.println(session);
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				BankAccount bankAccount = new BankAccount();
				bankAccount.setAccno(5684);
				session.delete(bankAccount);
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (transaction!=null) {
				if (flag) {
					transaction.commit();
					System.out.println("✅ Record Deleted successfully!");
				} else {
					transaction.rollback();
					System.out.println("❌ Record Deletion Failed");
				} 
			}
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
