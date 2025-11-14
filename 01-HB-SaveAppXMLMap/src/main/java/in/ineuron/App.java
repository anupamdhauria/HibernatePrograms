package in.ineuron;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
      Session session = HibernateUtil.getSession();
      Transaction transaction = session.beginTransaction();
      
      Student student=new Student();
      student.setSname("sunil");
      student.setSaddress("Jamshedpur");
      student.setMarks(56.2);
      
      session.save(student);
      transaction.commit();
      HibernateUtil.closeSession(session);
      HibernateUtil.closeSessionFactory();
      System.out.println("✅ Record inserted successfully!");
    }
}
