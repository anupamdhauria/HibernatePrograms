package in.ineuron;

import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import org.hibernate.Session;

public class SaveOrUpdateApp {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	Session session=null;
    	boolean flag=false;
    	Integer id=11;
    	try {
		      session = HibernateUtil.getSession();
		     
		      if(session!=null)
		    	transaction = session.beginTransaction();
		      
		      
		      if(transaction!=null) {
		    	  Student student=new Student();
		    	  Integer id1=session.get(Student.class,id)==null?null:id;
		    	  System.out.println(id1);
		    	  student.setSid(id1);
			      student.setSname("Narine");
			      student.setSaddress("KKR");
			      student.setMarks(70.6);
			      session.merge(student);
			      flag=true;
		      }
		    	  
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(flag) {
	    		transaction.commit();
	    		System.out.println("✅ Record Updated OR Inserted successfully!");
	    	}else {
	    		transaction.rollback();
	    		System.out.println("❌ Record Updation OR Insertion Failed");
	    	}
	    	if(session!=null) {
	    		  HibernateUtil.closeSession(session);
	    	}
	    	HibernateUtil.closeSessionFactory();
	    }
}
}
