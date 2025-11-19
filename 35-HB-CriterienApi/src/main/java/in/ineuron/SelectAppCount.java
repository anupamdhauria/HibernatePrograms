package in.ineuron;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;


public class SelectAppCount {

	
	
	public static void main(String[] args) {
		
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Long> cq = cb.createQuery(Long.class);
			Root<InsurancePolicy> root = cq.from(InsurancePolicy.class);
			cq.select(cb.count(root));
			Query<Long> query = session.createQuery(cq);
			Long totalInsurance = query.getSingleResult();
			System.out.println("Total Insurance is ::"+totalInsurance);
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
