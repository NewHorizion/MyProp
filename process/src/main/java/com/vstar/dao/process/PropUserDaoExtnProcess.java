package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropUsersDao;

/**
 * PropUsersDaoProcess
 * 
 */
public class PropUserDaoExtnProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropUsersDao
   * @throws HibernateException
   */
  public PropUsersDao addUpdatePropUsersDaoExtn(PropUsersDao propUsersDao)
      throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropUsersDao) session.merge(propUsersDao);
  }

  /**
   * 
   * @param PropUsersDaoid
   * @throws HibernateException
   */
  public void deletePropUsersDaoExtn(String userId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropUsersDao propUsersDao = (PropUsersDao) session.load(PropUsersDao.class, userId);
    session.delete(propUsersDao);
  }

  /**
   * @return
   */
  public List<PropUsersDao> getAllPropUsersDaoExtns() throws HibernateException
  {
    List<PropUsersDao> propUsersDaos = new ArrayList<PropUsersDao>();
    Session session = sessionFactory.getCurrentSession();
    propUsersDaos = session.createQuery("from PropUsersDao").list();
    return propUsersDaos;
  }

  /**
   * @param PropUsersDaoid
   * @return
   */
  public PropUsersDao getPropUsersDaoExtnById(String userId) throws HibernateException
  {
    PropUsersDao propUsersDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropUsersDao where userId = :userId";
    Query query = session.createQuery(queryString);
    query.setString("userId", userId);
    propUsersDao = (PropUsersDao) query.uniqueResult();
    return propUsersDao;
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
