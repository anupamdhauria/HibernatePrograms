package in.ineuron;


import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;

import java.io.Serializable;

import org.hibernate.Session;

public class SelectApp implements Serializable {
   
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
    {
    
    	Session session=null;
   
    	try {
		      session = HibernateUtil.getSession();
		      System.out.println(session);
		      if(session!=null)
		      {
		    	
		    	PersonInfo object = session.get(PersonInfo.class,1);
		    	if(object!=null) {
		    		System.out.println(object);
		    	}else {
		    		System.out.println("Record not found");
		    	}
		    	
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
