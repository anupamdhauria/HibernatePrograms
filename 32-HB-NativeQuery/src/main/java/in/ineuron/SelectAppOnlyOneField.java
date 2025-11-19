package in.ineuron;

import in.ineuron.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

public class SelectAppOnlyOneField {

	
@SuppressWarnings("deprecation")
public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			@SuppressWarnings("unchecked")
			NativeQuery<String> nativeQuery = session.createNativeQuery("SELECT policyName FROM insurancepolicy WHERE tenure>=:minTenure AND tenure<=:maxTenure");
			nativeQuery.setParameter("minTenure", 5);
			nativeQuery.setParameter("maxTenure",20);
			List<String> resultList = nativeQuery.getResultList();
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
