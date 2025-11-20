package in.ineuron.model;
// Generated 20 Nov 2025, 12:22:45 pm by Hibernate Tools 5.4.33.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Insurancepolicy.
 * @see in.ineuron.model.Insurancepolicy
 * @author Hibernate Tools
 */
public class InsurancepolicyHome {

	private static final Logger logger = Logger.getLogger(InsurancepolicyHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Insurancepolicy transientInstance) {
		logger.log(Level.INFO, "persisting Insurancepolicy instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Insurancepolicy instance) {
		logger.log(Level.INFO, "attaching dirty Insurancepolicy instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(Insurancepolicy instance) {
		logger.log(Level.INFO, "attaching clean Insurancepolicy instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(Insurancepolicy persistentInstance) {
		logger.log(Level.INFO, "deleting Insurancepolicy instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public Insurancepolicy merge(Insurancepolicy detachedInstance) {
		logger.log(Level.INFO, "merging Insurancepolicy instance");
		try {
			Insurancepolicy result = (Insurancepolicy) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Insurancepolicy findById(java.lang.Integer id) {
		logger.log(Level.INFO, "getting Insurancepolicy instance with id: " + id);
		try {
			Insurancepolicy instance = (Insurancepolicy) sessionFactory.getCurrentSession()
					.get("in.ineuron.model.Insurancepolicy", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(Insurancepolicy instance) {
		logger.log(Level.INFO, "finding Insurancepolicy instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("in.ineuron.model.Insurancepolicy")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
