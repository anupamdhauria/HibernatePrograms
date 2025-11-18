package in.ineuron;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateApp implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id = 1;
		BankAccount account=null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			System.out.println(session);

			account = session.get(BankAccount.class, id);
			if(account==null) {
				System.out.println("Record not found on ID:"+id);
				System.exit(0);
			}

			if (session != null) {
				transaction = session.beginTransaction();
			}
			
			if (transaction != null) {
				System.out.println("before transaction::" + account);
				account.setBalance(account.getBalance()+10000);
				session.update(account);
				flag = true;
			}
			
		}catch(

	Exception e)
	{
		e.printStackTrace();

	}finally
	{
		if (flag) {
			transaction.commit();
			System.out.println("✅ Record Updated successfully!");
			System.out.println("After transaction::" + account);
			System.out.println("Account Opening Date:"+account.getAccountOpeningDate());
			System.out.println("Account Updation Date:"+account.getAccountUpdationDate());
			System.out.println("Account Update Count::"+account.getAccountUpdateCount());
		} else {
			transaction.rollback();
			System.out.println("❌ Record Updation Failed");
		}
		if (session != null) {
			HibernateUtil.closeSession(session);
		}
		HibernateUtil.closeSessionFactory();
	}
}}
