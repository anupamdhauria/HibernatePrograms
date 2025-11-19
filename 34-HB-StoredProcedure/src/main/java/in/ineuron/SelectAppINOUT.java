package in.ineuron;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;
import jakarta.persistence.ParameterMode;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;


public class SelectAppINOUT {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Session session = null;
		Integer id=7;
		
		try {
			session = HibernateUtil.getSession();
			ProcedureCall procedure = session.createStoredProcedureCall("PGET_INSURANCENAMECOMPANY_BYID");
			procedure.registerParameter(1, Integer.class, ParameterMode.IN);
			procedure.registerParameter(2, String.class, ParameterMode.OUT);
			procedure.registerParameter(3, String.class, ParameterMode.OUT);
			procedure.setParameter(1,id);

			procedure.execute();
			
			String insuranceName=(String)procedure.getOutputParameterValue(2);
			String companyName=(String)procedure.getOutputParameterValue(3);
			
			System.out.println(insuranceName+"\t"+companyName);
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
