package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class InsertApp {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	Session session=null;
    	boolean flag=false;
    	try {
		      session = HibernateUtil.getSession();
		     System.out.println(session);
		      if(session!=null)
		    	transaction = session.beginTransaction();
		      
		      
		      if(transaction!=null) {
		    	  Student student=new Student();
		    	 
			      student.setSname("abd");
			      student.setSaddress("rcb");
			      student.setMarks(86.9);
			      session.persist(student);
			      flag=true;
		      }
		    	  
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(flag) {
	    		transaction.commit();
	    		System.out.println("✅ Record Inserted successfully!");
	    	}else {
	    		transaction.rollback();
	    		System.out.println("❌ Record  Insertion Failed");
	    	}
	    	if(session!=null) {
	    		  HibernateUtil.closeSession(session);
	    	}
	    	HibernateUtil.closeSessionFactory();
	    }
}
}
