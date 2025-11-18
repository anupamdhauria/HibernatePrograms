package in.ineuron;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientApp2 implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Session session = null;
		Integer id = 1;
		InsurancePolicy policy = null;
		Transaction transaction=null;
		try {
			session = HibernateUtil.getSession();
			System.out.println(session);
			transaction=session.beginTransaction();
			policy = session.get(InsurancePolicy.class, id);
		
			if(policy!=null) {
				policy.setTenure(16);
				System.out.println(policy);
			}
			else
				System.out.println("Record not found");
		

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			transaction.commit();
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
