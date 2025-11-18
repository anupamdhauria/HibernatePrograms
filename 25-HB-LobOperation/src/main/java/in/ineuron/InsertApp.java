package in.ineuron;

import org.hibernate.Transaction;


import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;

public class InsertApp implements Serializable {
   
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
    
    	Transaction transaction=null;
    	Session session=null;
    	boolean flag=false;
    	Integer id=null;
    	
    	byte[] photo=null;
    	char[] resume=null;
    	try {
		      session = HibernateUtil.getSession();
		      System.out.println(session);
		      if(session!=null)
		    	transaction = session.beginTransaction();
		      
		      
		      if(transaction!=null) {
		    	
		    	JobSeeker seeker = new JobSeeker();
		    
		    	seeker.setJsName("anupam");
		    	seeker.setJsAddr("jamshedpur");
		    	try(FileInputStream fis=new FileInputStream("D:\\images\\anupam.jpg")){
		    		photo=new byte[fis.available()];
		    		fis.read(photo);
		    	}
		    	
	    		File f=new File("D:\\images\\resume.txt");
	    		try(FileReader fr=new FileReader(f)){
	    			resume=new char[(int)f.length()];
	    			fr.read(resume);
	    		}
	    		
	    		seeker.setPhoto(photo);
	    		seeker.setResume(resume);	
	    		id=(Integer)session.save(seeker);
		    	 flag=true;
		      }
		    	  
		      
    	}catch(Exception e) {
    		e.printStackTrace();   
    		
	    }finally{
	    	
	    	if(flag) {
	    		transaction.commit();
	    		System.out.println("✅ Record inserted successfully!");
	    		System.out.println("Object saved with id:"+id);
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
