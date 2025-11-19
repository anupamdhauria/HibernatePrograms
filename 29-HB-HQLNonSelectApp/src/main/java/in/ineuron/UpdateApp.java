package in.ineuron;


import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UpdateApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction=null;
		boolean flag=false;
		int count=0;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null)
				transaction=session.beginTransaction();
			Query query = session.createQuery("UPDATE in.ineuron.model.Student SET marks=marks+:value WHERE sname  LIKE :initialValue");
			query.setParameter("value", 10);
			query.setParameter("initialValue","A%");
			count=query.executeUpdate();
			flag=true;
		
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record Updated Successfully✅✅");
				System.out.println("No of Rows Affected::"+count);
			}else {
				transaction.rollback();
				System.out.println("Record Updation Failed ❌");
				System.out.println("No of Rows Affected::"+count);
			}

			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
