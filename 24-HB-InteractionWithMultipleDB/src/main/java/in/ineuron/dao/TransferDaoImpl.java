package in.ineuron.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Product;
import in.ineuron.util.MySqlHibernateUtil;
import in.ineuron.util.OracleHibernateUtil;

public class TransferDaoImpl implements ITransferDao {

	@Override
	public String transaferProductById(Integer id) {
		
		Session oracleSession=null;
		Session mysqlSession=null;
		Transaction mysqlTransaction=null;
		Integer idValue=null;
		boolean flag=false;
		
		try {
			oracleSession=OracleHibernateUtil.getSession();
			Product product= oracleSession.get(Product.class, id);
			if(product==null) {
				System.out.println("Record not found with id::"+id);
			}else {
				 mysqlSession=MySqlHibernateUtil.getSession();
				mysqlTransaction=mysqlSession.beginTransaction();
				if(mysqlTransaction!=null)
					idValue=(Integer)mysqlSession.save(product);
				flag=true;
			}
						
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				if (flag) {
					mysqlTransaction.commit();
					return "Data copied from oracle to mysql with the id :: " + idValue;
				} else {
					mysqlTransaction.rollback();
					return "Data not copied from oracle to mysql with the id :: " + idValue;
				}
			}
			if(oracleSession!=null) {
				OracleHibernateUtil.closeSession(oracleSession);
			}
			if(mysqlSession!=null) {
				MySqlHibernateUtil.closeSession(mysqlSession);
			}
		}
		
		return null;
	}

}
