package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class TestApp {
	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	Session session=null;
    	boolean flag=false;
    	Integer id=6;
    	try {
		      session = HibernateUtil.getSession();
		      Student student = session.get(Student.class, id);
		      System.out.println("Before updation:"+student);
		    
		      if(student!=null) {
		    	  
		    	  System.in.read();//hold for record change in db
		    	  session.refresh(student);
		    	  System.out.println("After updation::"+student);
		      }
		      
		      
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(session!=null) {
	    		  HibernateUtil.closeSession(session);
	    	}
	    	HibernateUtil.closeSessionFactory();
	    }
}
}
