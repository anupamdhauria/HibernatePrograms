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


public class SelectAppOrderBy {

	
	
	public static void main(String[] args) {
		
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<InsurancePolicy> cr = cb.createQuery(InsurancePolicy.class);
			Root<InsurancePolicy> root = cr.from(InsurancePolicy.class);
			cr.select(root)
			.where(cb.equal(root.get("policyType"), "Life Insurance"))
			.orderBy(cb.desc(root.get("tenure")));
			Query<InsurancePolicy> query = session.createQuery(cr);
			List<InsurancePolicy> resultList = query.getResultList();
			resultList.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
