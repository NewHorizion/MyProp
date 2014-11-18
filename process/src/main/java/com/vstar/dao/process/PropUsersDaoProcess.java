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
public class PropUsersDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropUsersDao
   * @throws HibernateException
   */
  public PropUsersDao addUpdatePropUsersDao(PropUsersDao PropUsersDao) throws HibernateException
  {
    Session session = sessionFactory.openSession();
    return (PropUsersDao) session.merge(PropUsersDao);
  }

  /**
   * 
   * @param PropUsersDaoid
   * @throws HibernateException
   */
  public void deletePropUsersDao(String usersId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropUsersDao propUsersDao = (PropUsersDao) session.load(PropUsersDao.class, usersId);
    session.delete(propUsersDao);
  }

  /**
   * @return
   */
  public List<PropUsersDao> getAllPropUsersDaos() throws HibernateException
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
  public PropUsersDao getPropUsersDaoById(String usersId) throws HibernateException
  {
    PropUsersDao propUsersDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropUsersDao where username = :username";
    Query query = session.createQuery(queryString);
    query.setString("username", usersId);
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
