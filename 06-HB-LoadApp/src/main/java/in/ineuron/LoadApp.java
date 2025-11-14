package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

import java.io.IOException;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

public class LoadApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Integer id = 4;
		try {
			session = HibernateUtil.getSession();
			Student student = session.load(Student.class, id);
			if (student != null) {
				System.out.println("Student id is      :: " + student.getSid());

				System.in.read();

				System.out.println("STUDENT NAME IS    :: " + student.getSname());
				System.out.println("STUDENT MARKS IS     :: " + student.getMarks());
				System.out.println("STUDENT ADDRESS IS :: " + student.getSaddress());
			} else
				System.out.println("Record not found for the given id :: " + id);

		} catch (ObjectNotFoundException e) {
			System.out.println(e.getMessage());

		} finally {

			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
