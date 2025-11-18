package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerId;
import in.ineuron.model.ProgrammerInfo;
import in.ineuron.util.HibernateUtil;

import java.io.Serializable;

import org.hibernate.Session;

public class InsertApp implements Serializable {
   
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	Session session=null;
    	boolean flag=false;
    	ProgrammerId pk=null;
    	try {
		      session = HibernateUtil.getSession();
		      System.out.println(session);
		      if(session!=null)
		    	transaction = session.beginTransaction();
		      
		      
		      if(transaction!=null) {
		    	ProgrammerId id = new ProgrammerId();
		    	id.setPid(100);
		    	id.setProjId(502);
		    	
		    	ProgrammerInfo info = new ProgrammerInfo();
		    	info.setId(id);
		    	info.setPname("Sachin");
		    	info.setProjName("India");
		    	info.setDeptNo(10);
		    	pk = (ProgrammerId) session.save(info);
		    	flag=true;
		      }
		    	  
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(flag) {
	    		transaction.commit();
	    		System.out.println("✅ Record inserted successfully!");
	    		System.out.println("Object saved with id:"+pk);
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
