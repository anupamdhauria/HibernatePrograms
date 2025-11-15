package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class UpdateApp1 {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	Session session=null;
    	boolean flag=false;
    	Integer id=6;
    	try {
		      session = HibernateUtil.getSession();
		      Student student = session.get(Student.class, id);
		      System.out.println(session);
		      if(session!=null)
		    	transaction = session.beginTransaction();
		      
		      
		      if(transaction!=null) {
		    	
			      student.setSaddress("DVM");
			      session.update(student);
			      flag=true;
		      }
		    	  
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(flag) {
	    		transaction.commit();
	    		System.out.println("✅ Record Updated successfully!");
	    	}else {
	    		transaction.rollback();
	    		System.out.println("❌ Record Updation Failed");
	    	}
	    	if(session!=null) {
	    		  HibernateUtil.closeSession(session);
	    	}
	    	HibernateUtil.closeSessionFactory();
	    }
}
}
