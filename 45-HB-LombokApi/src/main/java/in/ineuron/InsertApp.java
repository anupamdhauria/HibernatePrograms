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
				emp.setEname("sachin");
				emp.setEaddress("MI");
				emp.setSalary(45000.0);
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
