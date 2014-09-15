package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.ReqPropTypeDao;

/**
 * ReqPropTypeDaoProcess
 * 
 */
public class ReqPropTypeDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param reqPropTypeDao
   * @throws HibernateException
   */
  public ReqPropTypeDao addUpdateReqPropTypeDao(ReqPropTypeDao reqPropTypeDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (ReqPropTypeDao)session.merge(reqPropTypeDao);
  }

  /**
   * 
   * @param reqPropTypeDaoId
   * @throws HibernateException
   */
  public void deleteReqPropTypeDao(int reqPropTypeDaoId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    ReqPropTypeDao reqPropTypeDao = (ReqPropTypeDao) session.load(ReqPropTypeDao.class, new Integer(
      reqPropTypeDaoId));
    session.delete(reqPropTypeDao);
  }

  /**
   * @return
   */
  public List<ReqPropTypeDao> getAllReqPropTypeDaos() throws HibernateException
  {
    List<ReqPropTypeDao> reqPropTypeDao = new ArrayList<ReqPropTypeDao>();
    Session session = sessionFactory.getCurrentSession();
    reqPropTypeDao = session.createQuery("from PropAreaDao").list();
    return reqPropTypeDao;
  }

  /**
   * @param reqPropTypeDaoId
   * @return
   */
  public ReqPropTypeDao getReqPropTypeDaoById(int reqPropTypeDaoId) throws HibernateException
  {
    ReqPropTypeDao reqPropTypeDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from ReqPropTypeDao where reqPropTypeId = :reqPropTypeDaoId";
    Query query = session.createQuery(queryString);
    query.setInteger("reqPropTypeDaoId", reqPropTypeDaoId);
    reqPropTypeDao = (ReqPropTypeDao) query.uniqueResult();
    return reqPropTypeDao;
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
