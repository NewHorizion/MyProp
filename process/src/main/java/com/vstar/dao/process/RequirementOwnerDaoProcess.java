package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.RequirementOwnerDao;

/**
 * RequirementOwnerDaoProcess
 * 
 */
public class RequirementOwnerDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param requirementOwnerDao
   * @throws HibernateException
   */
  public RequirementOwnerDao addUpdateRequirementOwnerDao(RequirementOwnerDao requirementOwnerDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (RequirementOwnerDao)session.merge(requirementOwnerDao);
  }

  /**
   * 
   * @param requirementOwnerDaoId
   * @throws HibernateException
   */
  public void deleteRequirementOwnerDao(int requirementOwnerDaoId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    RequirementOwnerDao requirementOwnerDao = (RequirementOwnerDao) session.load(RequirementOwnerDao.class, new Integer(
      requirementOwnerDaoId));
    session.delete(requirementOwnerDao);
  }

  /**
   * @return
   */
  public List<RequirementOwnerDao> getAllRequirementOwnerDaos() throws HibernateException
  {
    List<RequirementOwnerDao> requirementOwnerDaos = new ArrayList<RequirementOwnerDao>();
    Session session = sessionFactory.getCurrentSession();
    requirementOwnerDaos = session.createQuery("from PropOwnerDao").list();
    return requirementOwnerDaos;
  }

  /**
   * @param requirementOwnerDaoId
   * @return
   */
  public RequirementOwnerDao getRequirementOwnerDaoById(int requirementOwnerDaoId) throws HibernateException
  {
    RequirementOwnerDao requirementOwnerDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from RequirementOwnerDao where requirementOwnerId = :requirementOwnerDaoId";
    Query query = session.createQuery(queryString);
    query.setInteger("requirementOwnerDaoId", requirementOwnerDaoId);
    requirementOwnerDao = (RequirementOwnerDao) query.uniqueResult();
    return requirementOwnerDao;
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
