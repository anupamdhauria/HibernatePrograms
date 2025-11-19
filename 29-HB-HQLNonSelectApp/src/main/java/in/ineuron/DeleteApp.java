package in.ineuron;


import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DeleteApp {

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
			Query query = session.createQuery("DELETE FROM in.ineuron.model.Student WHERE sid=:value");
			query.setParameter("value", 10);
			count=query.executeUpdate();
			flag=true;
		
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record DELETED Successfully✅✅");
				System.out.println("No of Rows Affected::"+count);
			}else {
				transaction.rollback();
				System.out.println("Record DELETION Failed ❌");
				System.out.println("No of Rows Affected::"+count);
			}

			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
