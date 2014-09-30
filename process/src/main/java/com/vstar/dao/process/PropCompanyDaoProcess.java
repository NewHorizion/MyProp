package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropCompanyDao;

/**
 * PropCompanyDaoProcess
 */
public class PropCompanyDaoProcess {
	private SessionFactory sessionFactory;

	/**
	 * @param PropCompanyDao
	 * @throws HibernateException
	 */
	public PropCompanyDao addUpdatePropCompanyDao(PropCompanyDao propCompanyDao)
			throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		return (PropCompanyDao) session.merge(propCompanyDao);
	}

	/**
	 * @param PropCompanyDaoid
	 * @throws HibernateException
	 */
	public void deletePropCompanyDao(long companyId) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		PropCompanyDao propCompanyDao = (PropCompanyDao) session.load(
				PropCompanyDao.class, new Long(companyId));
		session.delete(propCompanyDao);
	}

	/**
	 * @return
	 */
	public List<PropCompanyDao> getAllPropCompanyDaos()
			throws HibernateException {
		List<PropCompanyDao> propCompanyDaos = new ArrayList<PropCompanyDao>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PropCompanyDao");
		propCompanyDaos = query.list();
		return propCompanyDaos;
	}

	/**
	 * @param PropCompanyDaoid
	 * @return
	 */
	public PropCompanyDao getPropCompanyDaoById(long companyId)
			throws HibernateException {
		PropCompanyDao propCompanyDao = null;
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from PropCompanyDao where companyId = :companyId";
		Query query = session.createQuery(queryString);
		query.setLong("propStateId", companyId);
		propCompanyDao = (PropCompanyDao) query.uniqueResult();
		return propCompanyDao;
	}

	/**
	 * @param companyName
	 * @return
	 */
	public PropCompanyDao getPropCompanyDaoByName(String companyName)
			throws HibernateException {
		PropCompanyDao propCompanyDao = null;
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from PropCompanyDao where companyName = :companyName";
		Query query = session.createQuery(queryString);
		query.setString("companyName", companyName);
		List<PropCompanyDao> companies = query.list();
		if (companies != null && companies.size() > 0) {
			propCompanyDao = companies.get(0);
		}
		return propCompanyDao;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
