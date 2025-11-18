package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
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

				InsurancePolicy policy = new InsurancePolicy();
				policy.setPolicyName("Jeevan Bima");
				policy.setPolicyType("Life Insurance");
				policy.setCompany("LIC");
				policy.setTenure(10);
				
				id = (Integer) session.save(policy);
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
