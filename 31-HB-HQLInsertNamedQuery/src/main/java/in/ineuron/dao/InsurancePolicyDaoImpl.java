package in.ineuron.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.util.HibernateUtil;
import jakarta.persistence.Query;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {
	

	@SuppressWarnings("deprecation")
	@Override
	public String transferPolicies(int tenure) {
		Session session = null;
		Transaction transaction=null;
		boolean flag=false;
		int count=0;
		String msg=null;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null)
				transaction=session.beginTransaction();
			Query query=session.getNamedQuery("HQL_TRANSFER_QUERY");
			query.setParameter("minTenure", tenure);
			count=query.executeUpdate();
			flag=true;
		
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record Inserted Successfully✅✅");
				msg="No of Rows Trasferred::"+count;
			}else {
				transaction.rollback();
				System.out.println("Record Insertion Failed ❌");
				msg="records not copied to table";
			}

			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			
		}
		return msg;
	}

}
