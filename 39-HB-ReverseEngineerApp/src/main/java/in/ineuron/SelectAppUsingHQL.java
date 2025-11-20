package in.ineuron;

import in.ineuron.model.Insurancepolicy;
import in.ineuron.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class SelectAppUsingHQL {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		
		Session session = null;
	
		try {
			session = HibernateUtil.getSession();
			Query<Insurancepolicy> query = session.createQuery("FROM in.ineuron.model.Insurancepolicy");
			List<Insurancepolicy> policies = query.getResultList();
			policies.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
