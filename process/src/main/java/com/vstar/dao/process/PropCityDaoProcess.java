package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.vstar.dao.PropCityDao;

/**
 * PropCityDaoProcess
 */
public class PropCityDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * @param PropCityDao
   * @throws HibernateException
   */
  public PropCityDao addUpdatePropCityDao(PropCityDao propCityDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropCityDao) session.merge(propCityDao);
  }

  /**
   * @param PropCityDaoid
   * @throws HibernateException
   */
  public void deletePropCityDao(int propCityDaoid) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropCityDao propCityDao = (PropCityDao) session.load(PropCityDao.class, new Integer(
      propCityDaoid));
    session.delete(propCityDao);
  }

  /**
   * Returning all Cities
   * 
   * @return
   */
  public List<PropCityDao> getAllPropCityDaos() throws HibernateException
  {
    List<PropCityDao> propCityDaos = new ArrayList<PropCityDao>();
    Session session = sessionFactory.getCurrentSession();
    propCityDaos = session.createQuery("from PropCityDao").list();
    return propCityDaos;
  }

  /**
   * Returning Cities by StateId
   * 
   * @return
   * @throws HibernateException
   */
  public List<PropCityDao> getAllPropCitiesByStateId(long stateId) throws HibernateException
  {
    List<PropCityDao> propCityDaos = new ArrayList<PropCityDao>();
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(PropCityDao.class);
    criteria.add(Restrictions.eq("propState", stateId));
    propCityDaos = criteria.list();
    return propCityDaos;
  }

  /**
   * @param PropCityDaoid
   * @return
   */
  public PropCityDao getPropCityDaoById(long propCityDaoid) throws HibernateException
  {
    PropCityDao propCityDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropCityDao where propCityId = :propCityId";
    Query query = session.createQuery(queryString);
    query.setLong("propCityId", propCityDaoid);
    propCityDao = (PropCityDao) query.uniqueResult();
    return propCityDao;
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
