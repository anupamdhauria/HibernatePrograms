package in.ineuron;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class InsertApp {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Employee emp=new Employee();
				emp.setEid(1234);
				emp.setEname("sachin");
				emp.setEaddress("MI");
				emp.setFriendList(List.of("dhoni","raina","rahul"));
				emp.setMobileNo(Set.of(5678965423L,2365789641L,4759612356L));
				emp.setBankAccount(Map.of("SBI",565236562L,"HDFC",9631483345L,"ICICI",7564896214L));
				session.persist(emp);
				flag =true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Objects saved to database");
			} else {
				transaction.rollback();
				System.out.println("Objects not inserted to the database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
