package in.ineuron;

import in.ineuron.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class InsertApp {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction=null;
		Boolean flag=false;
		Integer rowAffected=0;
		
		try {
			session = HibernateUtil.getSession();
			transaction=session.beginTransaction();
			@SuppressWarnings({ "rawtypes" })
			NativeQuery  nativeQuery = session.createNativeQuery("Insert Into insurancepolicy(policyName,company,policyType,tenure)values(?,?,?,?)");
			
			nativeQuery.setParameter(1, "jeevan beema");
			nativeQuery.setParameter(2,"LIC");
			nativeQuery.setParameter(3,"mediacal insurance");
			nativeQuery.setParameter(4,20);
			rowAffected=nativeQuery.executeUpdate();
			flag=true;
		
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record Inserted Successfully✅✅");
				System.out.println("No of row affected::"+rowAffected);
			}else {
				transaction.rollback();
				System.out.println("Record Insertion Failed ❌");
				System.out.println("No of row affected::"+rowAffected);
			}


			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
