package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropInfoExtDao;

/**
 * PropInfoExtDaoProcess
 * 
 */
public class PropInfoExtDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropInfoExtDao
   * @throws HibernateException
   */
  public PropInfoExtDao addUpdatePropInfoExtDao(PropInfoExtDao propInfoExtDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropInfoExtDao)session.merge(propInfoExtDao);
  }

  /**
   * 
   * @param PropInfoExtDaoid
   * @throws HibernateException
   */
  public void deletePropInfoExtDao(int propInfoId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropInfoExtDao propInfoExtDao = (PropInfoExtDao) session.load(PropInfoExtDao.class,
        new Integer(propInfoId));
    session.delete(propInfoExtDao);
  }

  /**
   * @return
   */
  public List<PropInfoExtDao> getAllPropInfoExtDaos() throws HibernateException
  {
    List<PropInfoExtDao> PropInfoExtDaos = new ArrayList<PropInfoExtDao>();
    Session session = sessionFactory.getCurrentSession();
    PropInfoExtDaos = session.createQuery("from PropInfoExtDao").list();
    return PropInfoExtDaos;
  }

  /**
   * @param PropInfoExtDaoid
   * @return
   */
  public PropInfoExtDao getPropInfoExtDaoById(int propInfoId) throws HibernateException
  {
    PropInfoExtDao propInfoExtDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropInfoExtDao where propInfoId = :propInfoId";
    Query query = session.createQuery(queryString);
    query.setInteger("propInfoId", propInfoId);
    propInfoExtDao = (PropInfoExtDao) query.uniqueResult();
    return propInfoExtDao;
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
