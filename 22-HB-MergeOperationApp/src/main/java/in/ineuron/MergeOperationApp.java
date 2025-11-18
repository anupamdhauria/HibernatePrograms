package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class MergeOperationApp {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	Session session=null;
    	boolean flag=false;
    	
    	try {
			
    		Student student=new Student();
    	
    		student.setSid(5);
		      student.setSname("Ganesh");
		      student.setSaddress("KXIP");
		      student.setMarks(90.3);
		      
		      session = HibernateUtil.getSession();
		     
		      if(session!=null)
		    	transaction = session.beginTransaction();
		      
		      
		      if(transaction!=null) {
		    	  session.merge(student);
			      flag=true;
		      }
		    	  
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(flag) {
	    		transaction.commit();
	    		System.out.println("✅ Record Updated or Insterted successfully!");
	    	}else {
	    		transaction.rollback();
	    		System.out.println("❌ Record  Updation or Insertion Failed");
	    	}
	    	if(session!=null) {
	    		  HibernateUtil.closeSession(session);
	    	}
	    	HibernateUtil.closeSessionFactory();
	    }
}
}
