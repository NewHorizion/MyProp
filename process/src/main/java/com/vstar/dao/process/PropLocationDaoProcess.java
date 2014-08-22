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
import com.vstar.dao.PropLocationDao;

/**
 * PropLocationDaoProcess
 */
public class PropLocationDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * @param PropLocationDao
   * @throws HibernateException
   */
  public PropLocationDao addUpdatePropLocationDao(PropLocationDao propLocationDao)
    throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropLocationDao) session.merge(propLocationDao);
  }

  /**
   * @param PropLocationDaoid
   * @throws HibernateException
   */
  public void deletePropLocationDao(long propLocationId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropLocationDao propLocationDao = (PropLocationDao) session.load(PropLocationDao.class,
      new Long(propLocationId));
    session.delete(propLocationDao);
  }

  /**
   * Returning all Locations
   * 
   * @return
   */
  public List<PropLocationDao> getAllPropLocationDaos() throws HibernateException
  {
    List<PropLocationDao> propLocationDaos = new ArrayList<PropLocationDao>();
    Session session = sessionFactory.getCurrentSession();
    propLocationDaos = session.createQuery("from PropLocationDao").list();
    return propLocationDaos;
  }

  /**
   * Returning Location Data by cityId
   * 
   * @param cityId
   * @return
   * @throws HibernateException
   */
  public List<PropLocationDao> getAllPropLocationsByCityId(long cityId) throws HibernateException
  {
    List<PropLocationDao> propLocationDaos = new ArrayList<PropLocationDao>();
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(PropLocationDao.class);
    criteria.add(Restrictions.eq("propCity", cityId));
    propLocationDaos = criteria.list();
    return propLocationDaos;
  }

  /**
   * @param PropLocationDaoid
   * @return
   */
  public PropLocationDao getPropLocationDaoById(long propLocationId) throws HibernateException
  {
    PropLocationDao propLocationDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropLocationDao where propLocationId = :propLocationId";
    Query query = session.createQuery(queryString);
    query.setLong("propLocationId", propLocationId);
    propLocationDao = (PropLocationDao) query.uniqueResult();
    return propLocationDao;
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
