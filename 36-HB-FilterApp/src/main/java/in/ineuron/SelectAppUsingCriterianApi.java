package in.ineuron;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

public class SelectAppUsingCriterianApi {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Filter filter = session.enableFilter("FILTER_BANKACCOUNT_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");
			HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<BankAccount> cq = cb.createQuery(BankAccount.class);
			Root<BankAccount> root = cq.from(BankAccount.class);
			cq.select(root).where(cb.gt(root.get("balance"), 25000.0));
			Query<BankAccount> query = session.createQuery(cq);
			List<BankAccount> accounts = query.getResultList();
			accounts.forEach(System.out::println);

			session.disableFilter("FILTER_BANKACCOUNT_STATUS");
			HibernateCriteriaBuilder cb1 = session.getCriteriaBuilder();
			CriteriaQuery<BankAccount> cq1 = cb1.createQuery(BankAccount.class);
			Root<BankAccount> root1 = cq1.from(BankAccount.class);
			cq1.select(root1).where(cb1.gt(root1.get("balance"), 25000.0));
			Query<BankAccount> query1 = session.createQuery(cq1);
			List<BankAccount> accounts1 = query1.getResultList();
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
