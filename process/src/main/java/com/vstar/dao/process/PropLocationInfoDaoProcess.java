package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropLocationInfoDao;

/**
 * PropLocationInfoDaoProcess
 * 
 */
public class PropLocationInfoDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param propLocationInfoDao
   * @throws HibernateException
   */
  public PropLocationInfoDao addUpdatePropAreaDao(PropLocationInfoDao propLocationInfoDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropLocationInfoDao)session.merge(propLocationInfoDao);
  }

  /**
   * 
   * @param propLocationInfoDaoId
   * @throws HibernateException
   */
  public void deletePropLocationInfoDao(int propLocationInfoDaoId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropLocationInfoDao propLocationInfoDao = (PropLocationInfoDao) session.load(PropLocationInfoDao.class, new Integer(
      propLocationInfoDaoId));
    session.delete(propLocationInfoDao);
  }

  /**
   * @return
   */
  public List<PropLocationInfoDao> getAllPropAreaDaos() throws HibernateException
  {
    List<PropLocationInfoDao> propLocationInfoDaos = new ArrayList<PropLocationInfoDao>();
    Session session = sessionFactory.getCurrentSession();
    propLocationInfoDaos = session.createQuery("from PropLocationInfoDao").list();
    return propLocationInfoDaos;
  }

  /**
   * @param propLocationInfoDaoId
   * @return
   */
  public PropLocationInfoDao getPropAreaDaoById(int propLocationInfoDaoId) throws HibernateException
  {
    PropLocationInfoDao propLocationInfoDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropLocationInfoDao where propLocationInfoId = :propLocationInfoDaoId";
    Query query = session.createQuery(queryString);
    query.setInteger("propLocationInfoDaoId", propLocationInfoDaoId);
    propLocationInfoDao = (PropLocationInfoDao) query.uniqueResult();
    return propLocationInfoDao;
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
