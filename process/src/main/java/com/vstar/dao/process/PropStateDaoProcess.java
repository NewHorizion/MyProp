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
 * 
 */
public class PropStateDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropStateDao
   * @throws HibernateException
   */
  public PropStateDao addUpdatePropStateDao(PropStateDao propStateDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropStateDao)session.merge(propStateDao);
  }

  /**
   * 
   * @param PropStateDaoid
   * @throws HibernateException
   */
  public void deletePropStateDao(int propStateId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropStateDao propStateDao = (PropStateDao) session.load(PropStateDao.class, new Integer(
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
    propStateDaos = session.createQuery("from PropStateDao").list();
    return propStateDaos;
  }

  /**
   * @param PropStateDaoid
   * @return
   */
  public PropStateDao getPropStateDaoById(int propStateId) throws HibernateException
  {
    PropStateDao propStateDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropStateDao where propStateId = :propStateId";
    Query query = session.createQuery(queryString);
    query.setInteger("propStateId", propStateId);
    propStateDao = (PropStateDao) query.uniqueResult();
    return propStateDao;
  }
}
