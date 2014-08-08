package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropPurchaseTypeDao;

/**
 * PropPurchaseTypeDaoProcess
 * 
 */
public class PropPurchaseTypeDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropPurchaseTypeDao
   * @throws HibernateException
   */
  public PropPurchaseTypeDao addUpdatePropPurchaseTypeDao(PropPurchaseTypeDao propPurchaseTypeDao)
      throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropPurchaseTypeDao)session.merge(propPurchaseTypeDao);
  }

  /**
   * 
   * @param PropPurchaseTypeDaoid
   * @throws HibernateException
   */
  public void deletePropPurchaseTypeDao(int propPurchaseId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropPurchaseTypeDao propPurchaseTypeDao = (PropPurchaseTypeDao) session.load(
        PropPurchaseTypeDao.class, new Integer(propPurchaseId));
    session.delete(propPurchaseTypeDao);
  }

  /**
   * @return
   */
  public List<PropPurchaseTypeDao> getAllPropPurchaseTypeDaos() throws HibernateException
  {
    List<PropPurchaseTypeDao> propPurchaseTypeDaos = new ArrayList<PropPurchaseTypeDao>();
    Session session = sessionFactory.getCurrentSession();
    propPurchaseTypeDaos = session.createQuery("from PropPurchaseTypeDao").list();
    return propPurchaseTypeDaos;
  }

  /**
   * @param PropPurchaseTypeDaoid
   * @return
   */
  public PropPurchaseTypeDao getPropPurchaseTypeDaoById(int propPurchaseId)
      throws HibernateException
  {
    PropPurchaseTypeDao propPurchaseTypeDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropPurchaseTypeDao where propPurchaseId = :propPurchaseId";
    Query query = session.createQuery(queryString);
    query.setInteger("propPurchaseId", propPurchaseId);
    propPurchaseTypeDao = (PropPurchaseTypeDao) query.uniqueResult();
    return propPurchaseTypeDao;
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
