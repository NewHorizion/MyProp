package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropOwnerDao;

/**
 * PropOwnerDaoProcess
 * 
 */
public class PropOwnerDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param propOwnerDao
   * @throws HibernateException
   */
  public PropOwnerDao addUpdatePropOwnerDao(PropOwnerDao propOwnerDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropOwnerDao)session.merge(propOwnerDao);
  }

  /**
   * 
   * @param propOwnerDaoId
   * @throws HibernateException
   */
  public void deletePropOwnerDao(int propOwnerDaoId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropOwnerDao propOwnerDao = (PropOwnerDao) session.load(PropOwnerDao.class, new Integer(
      propOwnerDaoId));
    session.delete(propOwnerDao);
  }

  /**
   * @return
   */
  public List<PropOwnerDao> getAllPropOwnerDaos() throws HibernateException
  {
    List<PropOwnerDao> propOwnerDaos = new ArrayList<PropOwnerDao>();
    Session session = sessionFactory.getCurrentSession();
    propOwnerDaos = session.createQuery("from PropOwnerDao").list();
    return propOwnerDaos;
  }

  /**
   * @param reqPropTypeDaoId
   * @return
   */
  public PropOwnerDao getPropOwnerDaoById(int propOwnerDaoId) throws HibernateException
  {
    PropOwnerDao propOwnerDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropOwnerDao where propOwnerId = :propOwnerId";
    Query query = session.createQuery(queryString);
    query.setInteger("propOwnerId", propOwnerDaoId);
    propOwnerDao = (PropOwnerDao) query.uniqueResult();
    return propOwnerDao;
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
