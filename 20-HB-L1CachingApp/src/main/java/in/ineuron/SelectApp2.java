package in.ineuron;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

import java.io.Serializable;

import org.hibernate.Session;

public class SelectApp2 implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				InsurancePolicy policy1 = session.get(InsurancePolicy.class, 1L);
				System.out.println("1:: "+policy1);
				System.out.println("------------------------");//gets from DB put in L1-cache
				
				InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1L);
				System.out.println("2:: "+policy2);
				System.out.println("------------------------");//gets from L1-cache
				
				session.evict(policy1);//Remove policy object from L1-cache
				
				InsurancePolicy policy3 = session.get(InsurancePolicy.class, 1L);
				System.out.println("3:: "+policy3);
				System.out.println("------------------------");//gets from DB put in L1-cache
				
				InsurancePolicy policy4 = session.get(InsurancePolicy.class, 1L);
				System.out.println("4:: "+policy4);
				System.out.println("------------------------");//gets from L1-cache
				
				InsurancePolicy policy5 = session.get(InsurancePolicy.class, 2L);
				System.out.println("5:: "+policy5);
				System.out.println("------------------------");//gets from DB put in L1-cache
				
				session.clear();//remove all objects from the cache
				
				InsurancePolicy policy6 = session.get(InsurancePolicy.class, 1L);
				System.out.println("6:: "+policy6);
				System.out.println("------------------------");//gets from DB and put it in L1-cache
				
				InsurancePolicy policy7 = session.get(InsurancePolicy.class, 2L);
				System.out.println("7:: "+policy7);
				System.out.println("------------------------");//gets from DB put it in L1-cache
				
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
