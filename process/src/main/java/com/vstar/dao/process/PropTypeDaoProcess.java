package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropTypeDao;

/**
 * PropTypeDaoProcess
 * 
 */
public class PropTypeDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropTypeDao
   * @throws HibernateException
   */
  public PropTypeDao addUpdatePropTypeDao(PropTypeDao propTypeDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropTypeDao)session.merge(propTypeDao);
  }

  /**
   * 
   * @param PropTypeDaoid
   * @throws HibernateException
   */
  public void deletePropTypeDao(int propTypeId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropTypeDao propTypeDao = (PropTypeDao) session
        .load(PropTypeDao.class, new Integer(propTypeId));
    session.delete(propTypeDao);
  }

  /**
   * @return
   */
  public List<PropTypeDao> getAllPropTypeDaos() throws HibernateException
  {
    List<PropTypeDao> propTypeDaos = new ArrayList<PropTypeDao>();
    Session session = sessionFactory.getCurrentSession();
    propTypeDaos = session.createQuery("from PropTypeDao").list();
    return propTypeDaos;
  }

  /**
   * @param PropTypeDaoid
   * @return
   */
  public PropTypeDao getPropTypeDaoById(int propTypeId) throws HibernateException
  {
    PropTypeDao propTypeDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropTypeDao where propTypeId = :propTypeId";
    Query query = session.createQuery(queryString);
    query.setInteger("propTypeId", propTypeId);
    propTypeDao = (PropTypeDao) query.uniqueResult();
    return propTypeDao;
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
