package in.ineuron;


import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Serializable;

import org.hibernate.Session;

public class SelectApp implements Serializable {
   
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
    {
    
    	Session session=null;
    	Integer id=1;
    	try {
		      session = HibernateUtil.getSession();
		      System.out.println(session);
		      if(session!=null)
		      {
		    	
		    	JobSeeker seeker = session.get(JobSeeker.class,id);
		    	if(seeker!=null) {
		    		System.out.println("JobSeeker Id is::"+seeker.getJsId());
		    		System.out.println("JobSeeker Name is:: "+seeker.getJsName());
		    		System.out.println("JobSeeker Address is::"+seeker.getJsAddr());
		    		
		    		try(FileWriter writer=new FileWriter("./store/resume.txt");FileOutputStream fos=new FileOutputStream("./store/"+seeker.getJsName()+".jpg")){
		    			fos.write(seeker.getPhoto());
		    			writer.write(seeker.getResume());
		    			System.out.println("Photo and resume got downloaded to :: ./store/****");
		    		}
		    		
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
