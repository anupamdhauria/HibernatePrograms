package in.ineuron;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class DeleteAppUsingHQL {
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
				Query<BankAccount> query = session.createQuery("UPDATE  in.ineuron.model.BankAccount SET status='closed' where accno=:no");
				query.setParameter("no", 1234);
				query.executeUpdate();
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
