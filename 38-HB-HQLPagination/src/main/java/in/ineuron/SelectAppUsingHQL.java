package in.ineuron;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class SelectAppUsingHQL {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		
		Session session = null;
		Integer maxRow=3;
		int count=0;
		int pageno=1;
		try {
			session = HibernateUtil.getSession();
			Query<Long> countQuery = session.createQuery("SELECT count(*) FROM in.ineuron.model.BankAccount");
			Long rowCount = (Long)countQuery.getSingleResult();
			
			Query<BankAccount> query = session.createQuery("FROM in.ineuron.model.BankAccount");
			while(count<rowCount) {
				query.setFirstResult(count);//record no start
				query.setMaxResults(maxRow);//no of records per page
				List<BankAccount> accounts = query.list();
				System.out.println("Page Number::"+pageno+"==============================================");
				accounts.forEach(System.out::println);
				count=count+maxRow;
				pageno++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
