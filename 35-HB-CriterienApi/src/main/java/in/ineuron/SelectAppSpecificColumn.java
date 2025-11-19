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


public class SelectAppSpecificColumn {

	
	
	public static void main(String[] args) {
		
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
			Root<InsurancePolicy> root = cq.from(InsurancePolicy.class);
			cq.multiselect(root.get("policyNo"),root.get("policyName"),root.get("company")).where(cb.and
					(cb.gt(root.get("tenure"), 5)),
					cb.lt(root.get("tenure"), 20));
			Query<Object[]> query = session.createQuery(cq);
			List<Object[]> resultList = query.getResultList();
			System.out.println("PNO\tPNAME\t\tCOMPANY");
			resultList.forEach(row->{
				for(Object object:row) {
					System.out.print(object+"\t");
				}
				System.out.println();
			});
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
