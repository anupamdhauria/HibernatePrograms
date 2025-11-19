package in.ineuron;


import in.ineuron.util.HibernateUtil;
import in.ineuron.dao.*;
public class InsertApp {

	
	public static void main(String[] args) {
		
		InsurancePolicyDao insurance=new InsurancePolicyDaoImpl();
		String policies = insurance.transferPolicies(10);
		System.out.println(policies);
		HibernateUtil.closeSessionFactory();
	}
}
