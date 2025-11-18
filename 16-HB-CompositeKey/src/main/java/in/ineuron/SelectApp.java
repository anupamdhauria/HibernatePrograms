package in.ineuron;


import in.ineuron.model.ProgrammerId;
import in.ineuron.model.ProgrammerInfo;
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
		    	ProgrammerId id = new ProgrammerId();
		    	id.setPid(101);
		    	id.setProjId(502);
		    	ProgrammerInfo object = session.get(ProgrammerInfo.class,id);
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
