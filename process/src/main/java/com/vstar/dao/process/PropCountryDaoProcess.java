package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropCountryDao;

/**
 * PropCountryDaoProcess
 */
public class PropCountryDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * @param PropCountryDao
   * @throws HibernateException
   */
  public PropCountryDao addUpdatePropCountryDao(PropCountryDao propCountryDao)
    throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropCountryDao) session.merge(propCountryDao);
  }

  /**
   * @param PropCountryDaoid
   * @throws HibernateException
   */
  public void deletePropCountryDao(long propCountryId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropCountryDao propCountryDao = (PropCountryDao) session.load(PropCountryDao.class, new Long(
      propCountryId));
    session.delete(propCountryDao);
  }

  /**
   * @return
   */
  public List<PropCountryDao> getAllPropCountryDaos() throws HibernateException
  {
    List<PropCountryDao> propCountryDaos = new ArrayList<PropCountryDao>();
    Session session = sessionFactory.getCurrentSession();
    propCountryDaos = session.createQuery("from PropCountryDao").list();
    return propCountryDaos;
  }

  /**
   * @param PropCountryDaoid
   * @return
   */
  public PropCountryDao getPropCountryDaoById(long propCountryId) throws HibernateException
  {
    PropCountryDao propCountryDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropCountryDao where propCountryId = :propCountryId";
    Query query = session.createQuery(queryString);
    query.setLong("propCountryId", propCountryId);
    propCountryDao = (PropCountryDao) query.uniqueResult();
    return propCountryDao;
  }

  /**
   * @return the sessionFactory
   */
  public SessionFactory getSessionFactory()
  {
    return sessionFactory;
  }

  /**
   * @param sessionFactory the sessionFactory to set
   */
  public void setSessionFactory(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }

}
