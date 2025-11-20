package in.ineuron;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class SelectAppUsingHQL {

	@SuppressWarnings({ "deprecation", "unchecked", "null" })
	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Filter filter = session.enableFilter("FILTER_BANKACCOUNT_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");
			Query<BankAccount> query = session.createQuery("FROM in.ineuron.model.BankAccount WHERE balance>:amt");
			query.setParameter("amt", 25000.00);
			List<BankAccount> accounts = query.list();
			accounts.forEach(System.out::println);

			session.disableFilter("FILTER_BANKACCOUNT_STATUS");
			Query<BankAccount> query1 = session.createQuery("FROM in.ineuron.model.BankAccount WHERE balance>:amt");
			query1.setParameter("amt", 25000.00);
			List<BankAccount> accounts1 = query1.list();
			accounts1.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null)
				HibernateUtil.closeSession(session);

			HibernateUtil.closeSessionFactory();
		}

	}
}
