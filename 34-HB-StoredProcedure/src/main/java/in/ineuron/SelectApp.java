package in.ineuron;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;
import jakarta.persistence.ParameterMode;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;


public class SelectApp {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			ProcedureCall procedure = session.createStoredProcedureCall("PGET_INSURANCE_BYTYPE");
			procedure.registerParameter(1, String.class, ParameterMode.IN);
			procedure.setParameter(1,"Life Insurance");
			
			@SuppressWarnings("unchecked")
			List<Object[]>insurances = procedure.getResultList();
			insurances.forEach(row->{
				for (Object object : row) {
					System.out.print(object+"\t");
				}
				System.out.println();
			});
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
