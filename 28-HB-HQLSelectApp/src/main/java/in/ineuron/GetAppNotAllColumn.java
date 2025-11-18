package in.ineuron;


import in.ineuron.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class GetAppNotAllColumn {

	public static void main(String[] args) {

		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			@SuppressWarnings({ "deprecation", "unchecked" })
			Query<Object[]> query = session.createQuery("SELECT sname,marks From in.ineuron.model.Student WHERE sname IN (:stud1,:stud2)");
			query.setParameter("stud1", "anupam");
			query.setParameter("stud2", "kavita");
				List<Object[]> list = query.list();
				System.out.println("========================================================");
				System.out.println("SNAME\tSMARKS");
				System.out.println("--------------------------------------------------------");
				list.forEach(row->{
					for(Object obj:row) {
						System.out.print(obj+"\t");
						
					}
					System.out.println();
				});
				System.out.println("========================================================");
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
