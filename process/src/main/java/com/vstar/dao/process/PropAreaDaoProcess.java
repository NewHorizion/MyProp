package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropAreaDao;

/**
 * PropAreaDaoProcess
 * 
 */
public class PropAreaDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param propAreaDao
   * @throws HibernateException
   */
  public PropAreaDao addUpdatePropAreaDao(PropAreaDao propAreaDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropAreaDao)session.merge(propAreaDao);
  }

  /**
   * 
   * @param propAreaDaoid
   * @throws HibernateException
   */
  public void deletePropAreaDao(int propAreaDaoid) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropAreaDao PropAreaDao = (PropAreaDao) session.load(PropAreaDao.class, new Integer(
        propAreaDaoid));
    session.delete(PropAreaDao);
  }

  /**
   * @return
   */
  public List<PropAreaDao> getAllPropAreaDaos() throws HibernateException
  {
    List<PropAreaDao> propAreaDaos = new ArrayList<PropAreaDao>();
    Session session = sessionFactory.getCurrentSession();
    propAreaDaos = session.createQuery("from PropAreaDao").list();
    return propAreaDaos;
  }

  /**
   * @param propAreaDaoid
   * @return
   */
  public PropAreaDao getPropAreaDaoById(int propAreaDaoid) throws HibernateException
  {
    PropAreaDao propAreaDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropAreaDao where propAreaId = :propAreaId";
    Query query = session.createQuery(queryString);
    query.setInteger("propAreaId", propAreaDaoid);
    propAreaDao = (PropAreaDao) query.uniqueResult();
    return propAreaDao;
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
