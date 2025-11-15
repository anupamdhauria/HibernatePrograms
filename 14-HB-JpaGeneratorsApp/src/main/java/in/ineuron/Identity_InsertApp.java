package in.ineuron;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student_Identity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Identity_InsertApp {

	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	SessionFactory sessionFactory=null;
    	Session session=null;
    	boolean flag=false;
    	Integer id=null;
    	try {
		    
    		sessionFactory= new Configuration().addAnnotatedClass(Student_Identity.class).configure().buildSessionFactory();
    		if(sessionFactory!=null) {
    			session=sessionFactory.openSession();
    		}
		   
		      if(session!=null)
		    	transaction = session.beginTransaction();
		      
		      
		      if(transaction!=null) {
		    	  Student_Identity student=new Student_Identity();
			      student.setSname("Akansha");
			      student.setSaddress("jsr");
			      student.setMarks(84.5);
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
