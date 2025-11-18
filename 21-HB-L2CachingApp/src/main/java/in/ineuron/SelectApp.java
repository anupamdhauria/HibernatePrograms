package in.ineuron;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

import java.io.Serializable;

import org.hibernate.Session;

public class SelectApp implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				InsurancePolicy policy1 = session.get(InsurancePolicy.class, 1);
				System.out.println("1:: "+policy1);
				System.out.println("------------------------");//gets from DB put in L2-cache and in L1-cache
				
				InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1);
				System.out.println("2:: "+policy2);
				System.out.println("------------------------");//gets from L1-cache
				
				session.evict(policy1);//Remove policy object from L1-cache
				
				InsurancePolicy policy3 = session.get(InsurancePolicy.class, 1);
				System.out.println("3:: "+policy3);
				System.out.println("------------------------");//gets from L2-cache and keep it in L1-cache
				
				session.clear();//remove all objects from L1-cache
				
				Thread.sleep(20000);//20secs(idleTimeout is expired so object removed from L2-cache)
				
				System.out.println();
				
				InsurancePolicy policy4 = session.get(InsurancePolicy.class, 1);
				System.out.println("4:: "+policy4);
				System.out.println("------------------------");//gets from DB put in L2-cache and in L1-cache
						
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		
		}finally
		{
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
			HibernateUtil.closeSessionFactory();
		}
}}
