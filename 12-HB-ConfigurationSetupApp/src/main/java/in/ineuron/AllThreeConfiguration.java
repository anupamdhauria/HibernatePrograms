package in.ineuron;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AllThreeConfiguration {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			Integer id=5;
			Configuration configuration = new Configuration();// this line will automatically load hibernate.properties
																// file

			//pure java
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql:///hibernatedb");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "root");
			configuration.setProperty("hibernate.connection.pool_size", "10");
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			configuration.setProperty("hibernate.show_sql", "true");
			configuration.setProperty("hibernate.format_sql", "true");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");

			configuration.addAnnotatedClass(Student.class);

			configuration.configure();// this line will load hibernate.cfg.xml file

			
			//properties file will override by pure java configuration
			//pura java configuration will override by xml 
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			if (session != null) {
				Student student = session.get(Student.class, id);
				System.out.println(student);
			} else {
				System.out.println("Record not found for ID:" + id);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}

		}
	}
}
