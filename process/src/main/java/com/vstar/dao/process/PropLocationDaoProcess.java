package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropLocationDao;

/**
 * PropLocationDaoProcess
 * 
 */
public class PropLocationDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropLocationDao
   * @throws HibernateException
   */
  public PropLocationDao addUpdatePropLocationDao(PropLocationDao propLocationDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropLocationDao)session.merge(propLocationDao);
  }

  /**
   * 
   * @param PropLocationDaoid
   * @throws HibernateException
   */
  public void deletePropLocationDao(int propLocationId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropLocationDao propLocationDao = (PropLocationDao) session.load(PropLocationDao.class, new Integer(
        propLocationId));
    session.delete(propLocationDao);
  }

  /**
   * @return
   */
  public List<PropLocationDao> getAllPropLocationDaos() throws HibernateException
  {
    List<PropLocationDao> PropLocationDaos = new ArrayList<PropLocationDao>();
    Session session = sessionFactory.getCurrentSession();
    PropLocationDaos = session.createQuery("from PropLocationDao").list();
    return PropLocationDaos;
  }

  /**
   * @param PropLocationDaoid
   * @return
   */
  public PropLocationDao getPropLocationDaoById(int propLocationId) throws HibernateException
  {
    PropLocationDao propLocationDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropLocationDao where propLocationId = :propLocationId";
    Query query = session.createQuery(queryString);
    query.setInteger("propLocationId", propLocationId);
    propLocationDao = (PropLocationDao) query.uniqueResult();
    return propLocationDao;
  }
}
