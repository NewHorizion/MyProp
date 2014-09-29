package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropStateDao;

/**
 * PropStateDaoProcess
 */
public class PropStateDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * @param PropStateDao
   * @throws HibernateException
   */
  public PropStateDao addUpdatePropStateDao(PropStateDao propStateDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropStateDao) session.merge(propStateDao);
  }

  /**
   * @param PropStateDaoid
   * @throws HibernateException
   */
  public void deletePropStateDao(long propStateId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropStateDao propStateDao = (PropStateDao) session.load(PropStateDao.class, new Long(
      propStateId));
    session.delete(propStateDao);
  }

  /**
   * @return
   */
  public List<PropStateDao> getAllPropStateDaos() throws HibernateException
  {
    List<PropStateDao> propStateDaos = new ArrayList<PropStateDao>();
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("from PropStateDao");
    propStateDaos = query.list();
    return propStateDaos;
  }

  /**
   * @param PropStateDaoid
   * @return
   */
  public PropStateDao getPropStateDaoById(long propStateId) throws HibernateException
  {
    PropStateDao propStateDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropStateDao where propStateId = :propStateId";
    Query query = session.createQuery(queryString);
    query.setLong("propStateId", propStateId);
    propStateDao = (PropStateDao) query.uniqueResult();
    return propStateDao;
  }

  /**
   * @param stateName
   * @return
   */
  public PropStateDao getPropStateDaoByName(String stateName) throws HibernateException
  {
    PropStateDao propStateDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropStateDao where stateName = :stateName";
    Query query = session.createQuery(queryString);
    query.setString("stateName", stateName);
    List<PropStateDao> states = query.list();
    if(states!=null && states.size()>0)
    {
    	propStateDao = states.get(0);
    }
    return propStateDao;
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
