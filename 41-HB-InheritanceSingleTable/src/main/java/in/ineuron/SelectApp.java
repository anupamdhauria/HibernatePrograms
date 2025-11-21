package in.ineuron;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.model.Payment;
import in.ineuron.util.HibernateUtil;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


public class SelectApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			Query<Payment> query = session.createQuery("FROM in.ineuron.model.Payment");
			List<Payment> resultList = query.getResultList();
			resultList.forEach(System.out::println);
			
			System.out.println("===================only card payment details==============");
			Query<CardPayment> query1 = session.createQuery("FROM in.ineuron.model.CardPayment");
			List<CardPayment> resultList1 = query1.getResultList();
			resultList1.forEach(System.out::println);
			
			System.out.println("===============only cheque payment details==================");
			Query<ChequePayment> query2 = session.createQuery("FROM in.ineuron.model.ChequePayment");
			List<ChequePayment> resultList2 = query2.getResultList();
			resultList2.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (session != null) 
				HibernateUtil.closeSession(session);
			
			HibernateUtil.closeSessionFactory();
		}
	
	}
}
