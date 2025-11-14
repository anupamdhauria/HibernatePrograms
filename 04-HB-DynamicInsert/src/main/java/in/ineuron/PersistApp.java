package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class PersistApp {

	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	Session session=null;
    	boolean flag=false;
    	Integer id=null;
    	try {
		      session = HibernateUtil.getSession();
		      System.out.println(session);
		      if(session!=null)
		    	transaction = session.beginTransaction();
		      
		      
		      if(transaction!=null) {
		    	  Student student=new Student();
			      student.setSname("rupali");
			      student.setSaddress("mango");
			      session.persist(student);
			      flag=true;
		      }
		    	  
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(flag) {
	    		transaction.commit();
	    		System.out.println("✅ Record inserted successfully!");
	    	}else {
	    		transaction.rollback();
	    		System.out.println("❌ Record Insertion Failed");
	    	}
	    	if(session!=null) {
	    		  HibernateUtil.closeSession(session);
	    	}
	    	HibernateUtil.closeSessionFactory();
	    }
}
}
