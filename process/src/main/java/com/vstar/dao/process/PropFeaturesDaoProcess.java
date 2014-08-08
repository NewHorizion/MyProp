package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropFeaturesDao;

/**
 * PropFeaturesDaoProcess
 * 
 */
public class PropFeaturesDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropFeaturesDao
   * @throws HibernateException
   */
  public PropFeaturesDao addUpdatePropFeaturesDao(PropFeaturesDao propFeaturesDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropFeaturesDao)session.merge(propFeaturesDao);
  }

  /**
   * 
   * @param PropFeaturesDaoid
   * @throws HibernateException
   */
  public void deletePropFeaturesDao(int propFeatureId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropFeaturesDao propFeaturesDao = (PropFeaturesDao) session.load(PropFeaturesDao.class,
        new Integer(propFeatureId));
    session.delete(propFeaturesDao);
  }

  /**
   * @return
   */
  public List<PropFeaturesDao> getAllPropFeaturesDaos() throws HibernateException
  {
    List<PropFeaturesDao> propFeaturesDaos = new ArrayList<PropFeaturesDao>();
    Session session = sessionFactory.getCurrentSession();
    propFeaturesDaos = session.createQuery("from PropFeaturesDao").list();
    return propFeaturesDaos;
  }

  /**
   * @param PropFeaturesDaoid
   * @return
   */
  public PropFeaturesDao getPropFeaturesDaoById(int propFeatureId) throws HibernateException
  {
    PropFeaturesDao propFeaturesDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropFeaturesDao where propFeatureId = :propFeatureId";
    Query query = session.createQuery(queryString);
    query.setInteger("propAreaId", propFeatureId);
    propFeaturesDao = (PropFeaturesDao) query.uniqueResult();
    return propFeaturesDao;
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
