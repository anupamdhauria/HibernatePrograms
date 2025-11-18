package in.ineuron;


import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class GetAppUniqueResultOptionalNullHandleByOptionalClass {

	public static void main(String[] args) {

		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			@SuppressWarnings({ "deprecation", "unchecked" })
			Query<Student> query = session.createQuery("From in.ineuron.model.Student WHERE sid=:id");
			System.out.println("Enter the Id to be fetched::");
			@SuppressWarnings("resource")
			int id=new Scanner(System.in).nextInt();
			query.setParameter("id", id);
			
			Optional<Student> optional = query.uniqueResultOptional();
			
			if (!optional.isEmpty()) {
				System.out.println(optional.get());
			} else {
				System.out.println("Record not found on this id::"+id);
			}
			
			
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
