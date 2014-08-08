package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropInfoCommentsExtDao;

/**
 * PropInfoCommentsExtDaoProcess
 * 
 */
public class PropInfoCommentsExtDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropInfoCommentsExtDao
   * @throws HibernateException
   */
  public PropInfoCommentsExtDao addUpdatePropInfoCommentsExtDao(PropInfoCommentsExtDao propInfoCommentsExtDao)
      throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropInfoCommentsExtDao)session.merge(propInfoCommentsExtDao);
  }

  /**
   * 
   * @param PropInfoCommentsExtDaoid
   * @throws HibernateException
   */
  public void deletePropInfoCommentsExtDao(int propInfoId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropInfoCommentsExtDao propInfoCommentsExtDao = (PropInfoCommentsExtDao) session.load(
        PropInfoCommentsExtDao.class, new Integer(propInfoId));
    session.delete(propInfoCommentsExtDao);
  }

  /**
   * @return
   */
  public List<PropInfoCommentsExtDao> getAllPropInfoCommentsExtDaos() throws HibernateException
  {
    List<PropInfoCommentsExtDao> PropInfoCommentsExtDaos = new ArrayList<PropInfoCommentsExtDao>();
    Session session = sessionFactory.getCurrentSession();
    PropInfoCommentsExtDaos = session.createQuery("from PropInfoCommentsExtDao").list();
    return PropInfoCommentsExtDaos;
  }

  /**
   * @param PropInfoCommentsExtDaoid
   * @return
   */
  public PropInfoCommentsExtDao getPropInfoCommentsExtDaoById(int propInfoId)
      throws HibernateException
  {
    PropInfoCommentsExtDao propInfoCommentsExtDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropInfoCommentsExtDao where propInfoId = :propInfoId";
    Query query = session.createQuery(queryString);
    query.setInteger("propInfoId", propInfoId);
    propInfoCommentsExtDao = (PropInfoCommentsExtDao) query.uniqueResult();
    return propInfoCommentsExtDao;
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
