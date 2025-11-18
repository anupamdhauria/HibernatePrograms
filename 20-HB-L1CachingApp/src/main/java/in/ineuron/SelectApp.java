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
				InsurancePolicy policy=session.get(InsurancePolicy.class, 1);//get from db and store in L1 cache
				System.out.println(policy);
				System.out.println("===================================================");
			
				InsurancePolicy policy1=session.get(InsurancePolicy.class, 1);
				System.out.println(policy1);
				System.out.println("===================================================");//get from L1 cache
				
				
				InsurancePolicy policy3=session.get(InsurancePolicy.class, 2);//get from db and store in L1 cache
				System.out.println(policy3);
				System.out.println("===================================================");
			
				InsurancePolicy policy4=session.get(InsurancePolicy.class, 2);
				System.out.println(policy4);
				System.out.println("===================================================");//get from L1 cache
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
