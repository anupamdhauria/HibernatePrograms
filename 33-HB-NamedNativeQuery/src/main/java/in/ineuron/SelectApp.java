package in.ineuron;

import in.ineuron.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class SelectApp {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
		
			@SuppressWarnings("unchecked")
			NativeQuery<Object[]> nativeQuery = session.getNamedNativeQuery("GET_RECORDS_BY_TYPE");
			
			nativeQuery.setParameter(1, "Life Insurance");
			List<Object[]> resultList = nativeQuery.getResultList();
			
			resultList.forEach(row->{
				for(Object obj:row) {
					System.out.print(obj+"\t");
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
