package in.ineuron;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class ConfigureUsingProperties {
	public static void main(String[] args) 
    {
		SessionFactory sessionFactory=null;
		Session session=null;
    	try {
    		Integer id=7;
    		Configuration configuration = new Configuration();//this line will automatically load hibernate.properties file
    		
    		
    		configuration.addAnnotatedClass(Student.class);
    		
    		
    		sessionFactory = configuration.buildSessionFactory();
    		session = sessionFactory.openSession();
    		if(session!=null) {
    			Student student = session.get(Student.class, id);
    			System.out.println(student);
    		}else {
    			System.out.println("Record not found for ID:"+id);
    		}
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(session!=null) {
	    		session.close();
	    	}
	    	if(sessionFactory!=null) {
	    		sessionFactory.close();
	    	}
	    }
}
}
