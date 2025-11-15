package in.ineuron;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import in.ineuron.model.Student_Increament;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Increament_InsertApp {

	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	SessionFactory sessionFactory=null;
    	Session session=null;
    	boolean flag=false;
    	Integer id=null;
    	try {
		    
    		sessionFactory= new Configuration().addAnnotatedClass(Student_Increament.class).configure().buildSessionFactory();
    		if(sessionFactory!=null) {
    			session=sessionFactory.openSession();
    		}
		   
		      if(session!=null)
		    	transaction = session.beginTransaction();
		      
		      
		      if(transaction!=null) {
		    	  Student_Increament student=new Student_Increament();
			      student.setSname("Anupam");
			      student.setSaddress("Galudih");
			      student.setMarks(86.5);
			       id = (Integer) session.save(student);
			      flag=true;
		      }
		    	  
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(flag) {
	    		transaction.commit();
	    		System.out.println("✅ Record inserted successfully with ID:"+id);
	    	}else {
	    		transaction.rollback();
	    		System.out.println("❌ Record Insertion Failed");
	    	}
	    	if(session!=null) {
	    		 session.close();
	    	}
	    	if(sessionFactory!=null) {
	    		sessionFactory.close();
	    	}
	    }
}
}
