package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropRequirementDao;

/**
 * PropRequirementDaoProcess
 * 
 */
public class PropRequirementDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param propRequirementDao
   * @throws HibernateException
   */
  public PropRequirementDao addUpdatePropRequirementDao(PropRequirementDao propRequirementDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropRequirementDao)session.merge(propRequirementDao);
  }

  /**
   * 
   * @param propRequirementDaoId
   * @throws HibernateException
   */
  public void deletePropRequirementDao(int propRequirementDaoId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropRequirementDao propRequirementDao = (PropRequirementDao) session.load(PropRequirementDao.class, new Integer(
        propRequirementDaoId));
    session.delete(propRequirementDao);
  }

  /**
   * @return
   */
  public List<PropRequirementDao> getAllPropRequirementDaos() throws HibernateException
  {
    List<PropRequirementDao> propRequirementDaos = new ArrayList<PropRequirementDao>();
    Session session = sessionFactory.getCurrentSession();
    propRequirementDaos = session.createQuery("from PropAreaDao").list();
    return propRequirementDaos;
  }

  /**
   * @param propRequirementDaoId
   * @return
   */
  public PropRequirementDao getPropRequirementDaoById(int propRequirementDaoId) throws HibernateException
  {
    PropRequirementDao propRequirementDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropRequirementDao where propRequirementId = :propRequirementDaoId";
    Query query = session.createQuery(queryString);
    query.setInteger("propRequirementDaoId", propRequirementDaoId);
    propRequirementDao = (PropRequirementDao) query.uniqueResult();
    return propRequirementDao;
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
