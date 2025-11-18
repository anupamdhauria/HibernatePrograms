package in.ineuron;

import in.ineuron.dao.TransferDaoImpl;
import in.ineuron.util.MySqlHibernateUtil;
import in.ineuron.util.OracleHibernateUtil;
import in.ineuron.dao.ITransferDao;
public class TestApp {
	public static void main(String[] args) 
    {
		ITransferDao dao = new TransferDaoImpl();
		System.out.println(dao.transaferProductById(30));
		OracleHibernateUtil.closeSessionFactory();
		MySqlHibernateUtil.closeSessionFactory();
    }
}
