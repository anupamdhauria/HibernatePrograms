package in.ineuron;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.util.HibernateUtil;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class InsertApp {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				CardPayment cardPayment = new CardPayment();
				cardPayment.setPid(1234);
				cardPayment.setAmount(5666.2);
				cardPayment.setCardNo(63656);
				cardPayment.setCardType("Debit");
				cardPayment.setPaymentGateway("VISA");
				
				
				ChequePayment chequePayment = new ChequePayment();
				chequePayment.setPid(5689);
				chequePayment.setAmount(96562.3);
				chequePayment.setChequeNo(6562);
				chequePayment.setChequeType("self");
				chequePayment.setExpiryDate(LocalDate.of(2027, 10, 25));
				
				session.persist(cardPayment);
				session.persist(chequePayment);
				
				flag =true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Objects saved to database");
			} else {
				transaction.rollback();
				System.out.println("Objects not inserted to the database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
